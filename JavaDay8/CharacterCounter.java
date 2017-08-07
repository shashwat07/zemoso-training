import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class CharacterCounter {

	
	public static void main(String[] args) throws IOException {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Please lenter the file name to be read ");
		String fileName = scan.nextLine();
		File file = new File(fileName);
		FileReader inputStream = new FileReader(file);
		
		System.out.println();
		Map<Character,Integer> charCounter = new HashMap<Character,Integer>();
		
		boolean present=false;
		int ch;
		int val;
		while((ch=inputStream.read())!=-1){
			char character = (char) ch;
			present = charCounter.containsKey(character);
			if(present){
				val = charCounter.get(character);
				val++;
				charCounter.put(character, val);
			}
			else{
				charCounter.put(character, 1);
			}
		}
		
		inputStream.close();
		
		System.out.println(charCounter);
		
	}

}
