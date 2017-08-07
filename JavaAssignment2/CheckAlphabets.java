import java.util.Scanner;

// *******************************************************************
//	
// 	Time Complexity -> O(n) : n is the lenth of string.
//	
//	Space Complexity -> O(n) : n is the lenth of string.
//
// *******************************************************************

public class CheckAlphabets {

	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		String line = null;
		System.out.println("Enter the string to check");
		line = scan.nextLine();
		boolean arr[] = new boolean[26];
		boolean flag = true;
		if(line.length()<26){
			flag=false;
		}
		for(int i=0;i<26;i++){
			arr[i]=false;
		}
		
		for(int i=0;i<line.length();i++){
			char ch = line.charAt(i);
			int val = (int) ch;
			if(val>64 && val <91){
				arr[val-65]=true;
			}
			else if(val>96 && val<123){
				arr[val-97]=true;
			}
		}
		
		for(int i=0;i<26;i++){
			if(arr[i]){
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

}
