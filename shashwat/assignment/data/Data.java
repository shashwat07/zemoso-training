package shashwat.assignment.data;

public class Data{
	int n;
	char c;

	public void printVariables(){
		System.out.println("value of int : " + n);
		System.out.println("value of char : " + c);
	}

	public void printLocalVariables(){
		int p;
		char ch;
		
		//#################################################
		//
		//THE CODE BELOW WON'T WORK BECAUSE JAVA PROGRAMMERS
		//ARE SUPPOSED TO INITIALIZE LOCAL VARIABLES AS 
		//THEIR SCOPE IS LIMITED, WHICH IS NOT THE CASE WITH
		//INSTANCE VARIABLES. IF USED WITHOUT INITIALIZATION
		//JAVA WILL CONSIDER IT A BUG AND SHOW AN ERROR.
		//
		//*************************************************
		//
		//System.out.println("value of int : " + p);
		//System.out.println("value of char : " + ch);
		//
		//#################################################
	}
}
