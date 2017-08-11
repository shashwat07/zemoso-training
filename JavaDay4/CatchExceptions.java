
public class CatchExceptions {
	
	public void callMethod() throws Exception{
		int arr[] = new int[5];
		// Code below gives ArrayIndexOutOfBounds Exception
		System.out.println(arr[8]); // **** comment this line to see NullPointer Exception
		
		CatchExceptions catchException = null;
		// Comment code for ArrayIndexOutOfBounds exception to see NullPointer Exception
		catchException.somefun(); // **** comment this line to see Arithmetic exception
		
		int number1=7,number2=0,result;
		// #*#*#*# Comment above two exceptions to see arithmetic exception
		result=number1/number2;  
		System.out.println(result);
		
		
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
