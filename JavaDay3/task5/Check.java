package task5;

public class Check {
	
	public static void main(String args[]){

		OuterClass1 outer1 = new OuterClass1();
		OuterClass2 outer2 = new OuterClass2();
		
		outer2.new InnerClass2(outer1, "Success!");
	}

}
