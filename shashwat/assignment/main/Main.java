package shashwat.assignment.main;

import shashwat.assignment.data.Data;
import shashwat.assignment.singleton.Singleton;

public class Main{
	public static void main(String args[]){

		Data data = new Data();
		data.printVariables();
		data.printLocalVariables();  // WON'T WORK ### REASON MENTIONED IN Data.java

		Singleton single = Singleton.fun("whad up?");
		
		single.printString(single);

	}
}