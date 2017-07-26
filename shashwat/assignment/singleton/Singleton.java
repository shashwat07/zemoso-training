package shashwat.assignment.singleton;

public class Singleton{
	String str;

	public static Singleton fun(String a){
		Singleton single = new Singleton();
		single.str=a;
		return single;
	}

	public void printString(Singleton sing){
		System.out.println(sing.str);
	}
}
