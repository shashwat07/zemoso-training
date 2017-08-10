import java.util.Scanner;
import java.util.regex.Pattern;


public class Regex {

	
	
	public static void main(String[] args) {
		
		String regex = "[A-Z].*\\.";  // Regular expression to check for line starting with capital alphabet and ending with period(.)
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the string to check for pattern, -1 to exit");
		String checkForPattern; 
		
		while(true){
			checkForPattern = scan.nextLine();  // take user input for strings to check for pattern
			if(checkForPattern.equals("-1")){   // exit if value entered is -1
				System.out.println("Program closed!");
				break;
			}
			else{
				boolean match = Pattern.matches(regex, checkForPattern);	// sets boolean to true if pattern matches
				if(match){
					System.out.println("Pattern Matches!");
				}
				else{
					System.out.println("Match not found!");
				}
			}
		}
		scan.close();
		
	}

}
