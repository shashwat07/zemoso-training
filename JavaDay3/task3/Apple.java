package task3;

public class Apple extends Fruit implements Interface4{

	public void met1() {
		System.out.println("I1 M1");
	}

	public void met2() {
		System.out.println("I1 M2");
		
	}

	public void meth1() {
		System.out.println("I2 M1");
		
	}

	public void meth2() {
		System.out.println("I2 M2");
		
	}

	public void method1() {
		System.out.println("I3 M1");
		
	}

	public void method2() {
		System.out.println("I3 M2");
		
	}

	public void newMethod() {
		System.out.println("C M1");
	}
	
	public void intMethod1(Interface1 in1){
		in1.met1();
		in1.met2();
		
	}
	
	public void intMethod2(Interface2 in2){
		in2.meth1();
		in2.meth2();
		
	}
	
	public void intMethod3(Interface3 in3){
		in3.method1();
		in3.method2();
		
	}
	
	public void intMethod4(Interface4 in4){
		in4.newMethod();
	}	

}
