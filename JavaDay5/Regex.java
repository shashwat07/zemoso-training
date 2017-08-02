import java.util.regex.Pattern;


public class Regex {

	
	
	public static void main(String[] args) {
		
		String s[] = new String[7];
		s[0] = ".";
		s[1] = "This should match the regex.";
		s[2] = s[1] + " Now it won't!";
		s[3] = "This shouldn't wor.k";
		s[4] = "won't work!";
		s[5] = "S.";
		s[6] = "s.";
		
		String regex = "[A-Z].*\\.";
		
		for(int i=0;i<7;i++){
			boolean b = Pattern.matches(regex, s[i]);
			if(b){
				System.out.println("Pattern Matches");
			}
			else{
				System.out.println("No Match!");
			}
		}
		
		

	}

}
