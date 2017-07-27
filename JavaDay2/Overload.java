
public class Overload {

	Overload(){
		this("Shashwat!");
	}
	
	Overload(String s1){
		System.out.println("Hi " + s1);
	}
	
	public static void main(String[] args) {
		
		new Overload();

	}

}
