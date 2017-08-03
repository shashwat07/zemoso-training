package ride;

public class Cycle {
	
	void balance(){
		System.out.println("balancing a cycle!");
	}

	
	
	public static void main(String[] args) {
		
		Cycle cyc[] = new Cycle[3];
		
		Tricycle tri = new Tricycle();
		Bicycle bi = new Bicycle();
		Unicycle uni = new Unicycle();
		
		cyc[0]=(Cycle)uni; // Explicitly upcasting, though not requried
		cyc[1]=bi; // Implicit upcasting
		cyc[2]=tri; // Implicit upcasting
		
		cyc[0].balance();
		cyc[1].balance(); 
		cyc[2].balance();
		
		
		Unicycle downUni = (Unicycle) cyc[0];   // Downcasting	
		Bicycle downBi = (Bicycle) cyc[1];		// Downcasting
		Tricycle downTri = (Tricycle) cyc[2];	// Downcasting
		
		downUni.balance();
		downBi.balance();
		downTri.balance();
				
	}

}
