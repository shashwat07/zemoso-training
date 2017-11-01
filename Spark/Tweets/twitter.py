import sys
from pyspark import SparkConf, SparkContext

conf = SparkConf()
conf.setAppName("TwitterStreamApp")
conf = conf.setMaster("local[*]")

sc = SparkContext(conf=conf)

infile = sc.textFile("/test/tweets-1.txt")

wc = infile.flatMap(lambda line: line.split(" ")).filter(lambda word: word.startswith("#")).map(lambda word: (word, 1)).reduceByKey(lambda x, y: x + y).map(lambda x: (x[1], x[0])).sortByKey(False).map(lambda x: (x[1], x[0]))

wcTop100 = wc.take(100)

outfile = open('/test/output.txt','w')

for w in wcTop100:
  print>>outfile, w

outfile.close()

sc.stop()
