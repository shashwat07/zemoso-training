package task3;

public class Fruit {
	
	public void taste(){
		System.out.println("this fruit tastes yuk!");
	}
	
	public static void main(String args[]){
		Apple apple = new Apple();
		
		apple.intMethod1(apple);
		apple.intMethod2(apple);
		apple.intMethod3(apple);
		apple.intMethod4(apple);
		
	}

}
