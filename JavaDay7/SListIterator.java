
public class SListIterator<T>{
	
	Link head;
	Link current;
	Link previous;
	Link prePrevious;

	public SListIterator(Link head) {
		this.head=head;
		current=head;
	}

	void insert(T val){
		Link node = new Link(val,null);
		current.next=node;
		previous=current;
		current=node;
	}
	
	void remove(){
		Link curr = head;
		int count = 0;
		while(curr.next!=null){
			prePrevious = previous;
			previous = curr;
			curr=curr.next;
			count++;
		}
		
		current = previous;
		current.next = null;
		previous = prePrevious;
		
		if(count>0){
			System.out.println("last link removed");
		}
		else{
			System.out.println("No links to remove");
		}
		
	}
	
	void iterate(){
		Link cur=head;
		while(cur!=null){
			if(cur!=head){
				System.out.print(" -> ");
			}
			System.out.print(cur.val);
			cur=cur.next;
		}
		System.out.println("");
	}
	
}
