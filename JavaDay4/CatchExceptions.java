
public class CatchExceptions {
	
	public void callMethod() throws Exception{
		int arr[] = new int[5];
		// Code below gives ArrayIndexOutOfBounds Exception
		System.out.println(arr[8]); // **** comment this line to see NullPointer Exception
		
		CatchExceptions ce1 = null;
		// Comment code for ArrayIndexOutOfBounds exception to see NullPointer Exception
		 ce1.somefun(); // **** comment this line to see Arithmetic exception
		
		int a=7,b=0,z=0;
		// #*#*#*# Comment above two exceptions to see arithmetic exception
		z=a/b;  
		System.out.println(z);
		
		
	}

	
	private void somefun() {
		System.out.println("some function!");
	}


	public static void main(String[] args) throws Exception {
		try{
			CatchExceptions ce = new CatchExceptions();
			ce.callMethod();
		}
		catch(ArrayIndexOutOfBoundsException | NullPointerException | ArithmeticException e){
			System.out.println(e);
		}
		finally{
			System.out.println("Finally block code executed!");
		}
	}

}
