package task5;

import task5.OuterClass1.InnerClass1;

public class OuterClass2 {
	
	class InnerClass2 extends InnerClass1{
		
		InnerClass2(OuterClass1 outer1, String s) {
			outer1.super(s);
		}
		
	}
}
