import java.util.Scanner;


public class CheckAlphabets {

	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		String toCheck = null;
		
		while(true){
			
			System.out.println("Enter the string to check, -1 to exit");
			toCheck = scan.nextLine();
			if(toCheck.equals("-1")){
				break;
			}
			
			boolean isPresent[] = new boolean[26];
			boolean flag = true;
			
			// if string is less than 26 characters 
			if(toCheck.length()<26){
				flag=false;
				System.out.println("Does not contain all the alphabets!");
				continue;
			}
			
			
			//Assigns boolean value true to indices for corresponding alphabets (0 -> a/A ..... 25 -> z/Z)
			for(int i=0;i<toCheck.length();i++){
				char character = toCheck.charAt(i);
				int val = (int) character;
				if(val>64 && val <91){
					isPresent[val-65]=true;
				}
				else if(val>96 && val<123){
					isPresent[val-97]=true;
				}
			}
			
			// Checks if all the alphabets are present
			for(int i=0;i<26;i++){
				if(isPresent[i]){
					flag=true;
				}
				else{
					flag=false;
					break;
				}
			}
			if(flag){
				System.out.println("Contains all the alphabets!");
			}
			else{
				System.out.println("Does not contain all the alphabets!");
			}
		}
		scan.close();
	}

}
