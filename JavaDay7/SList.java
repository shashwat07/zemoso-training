import java.util.Scanner;


public class SList<T> {
	
	static Link head;

	private static SListIterator iterator(Link head){
		
		SListIterator iter = new SListIterator(head);
		return iter;
		
	}
	
	public static void main(String args[]){
		
		SList sl = new SList();
		head = new Link("Head Link",null);
		SListIterator iter = iterator(head);
		
		while(true){
			System.out.println("Press 1 to add a new link");
			System.out.println("Press 2 to remove the last link");
			System.out.println("Press 3 to print the list");
			System.out.println("Press -1 to exit");
			
			Scanner scan = new Scanner(System.in);
			int response = scan.nextInt();
			
			
			if(response == 1){
				System.out.println("give data for new link");
				iter.insert(scan.next());
			}
			else if(response == 2){
				iter.remove();
			}
			else if(response == 3){
				iter.iterate();
			}
			else if(response == -1){
				break;
			}
			else{
				System.out.println("Invalid respone!");
			}
		}
		
	}
	
}
