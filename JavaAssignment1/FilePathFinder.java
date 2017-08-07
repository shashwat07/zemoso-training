import java.io.File;
import java.util.Scanner;
import java.util.regex.Pattern;


public class FilePathFinder {

	private static int getFile(File file, String regex){
		
		boolean found = false;
		int count = 0;
		for(File files : file.listFiles()){
			if(files.isDirectory()){
				count+=getFile(files,regex);
			}
			else if(files.isFile()){
				String fileName = files.getName();
				found = Pattern.matches(regex, fileName);
				if(found){
					System.out.println(files.getAbsolutePath());
					count++;
				}
				
			}
			
		}
		return count;
		
	}
	
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		String regex = null;
		File baseFolder = new File("/home");
		File[] listOFiles = baseFolder.listFiles();
		boolean found = false;
		int count=0;
		while(true){
			System.out.println("Enter a regular expression to search files, to quit enter -1");
			regex = scan.nextLine();
			if(regex.equals("-1")){
				break;
			}
			
			
			for(File file : listOFiles){					
				if(file.isDirectory()){
					count+=getFile(file,regex);
				}
				else if(file.isFile()){
					String fileName = file.getName();
					found = Pattern.matches(regex, fileName);
					if(found){
						System.out.println(file.getAbsolutePath());
						count++;
					}
				}
			}
			
			if(count==0){
				System.out.println("File not found!");
			}
			
			
		}
		
		

	}

}
