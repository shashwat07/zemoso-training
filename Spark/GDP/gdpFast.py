from pyspark.sql import SparkSession
spark = SparkSession \
    .builder \
    .appName("GdpGrowth") \
	.getOrCreate()


df = spark.read \
         .format("csv") \
         .option("header", "true") \
         .option("inferschema", "true") \
         .load("bin/test/gdp.csv")


from pyspark.sql.functions import col, lead, rank
from pyspark.sql import Window

windowSpec = Window.partitionBy("Country Name").orderBy("Year")
diff = lead("Value", 1).over(windowSpec) - col("Value")
diff = diff / col("Value") * 100

df_new = df.withColumn("diff", diff)

windowNew = Window.partitionBy("Year").orderBy(col("diff").desc())

df_final = df_new.select("Year", "Country Name" , rank().over(windowNew).alias('rank')).filter(col('rank') < 2 ).drop("rank")
df_final.orderBy("Year").where(col("Year") != 2016).show(100)