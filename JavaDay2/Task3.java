
public class Task3 {
	
	Task3(String s){
		System.out.println(s);
	}
	
	
	public static void main(String[] args) {
		
		Task3 arr[] = new Task3[3];
		
		// Nothing was printed when objects were not created.
		// These below are part of Java Day 2 Task 4.
		arr[0] = new Task3("hello");
		arr[1] = new Task3("Hi");
		arr[2] = new Task3("hey");
		

	}

}
