package ride;

public class Cycle {

	
	
	public static void main(String[] args) {
		
		Cycle cyc[] = new Cycle[3];
		
		Tricycle tri = new Tricycle();
		Bicycle bi = new Bicycle();
		Unicycle uni = new Unicycle();
		
		cyc[0]=(Cycle)uni; // Explicitly upcasting, though not requried
		cyc[1]=bi; // Implicit upcasting
		cyc[2]=tri; // Implicit upcasting
		
		uni.balance();
		bi.balance();
		// 
		// tri.balance();
		//
		//shows error message because there is no balance method in Tricycle class.
		
		Unicycle downUni = (Unicycle) cyc[0];	
		Bicycle downBi = (Bicycle) cyc[1];
		Tricycle downTri = (Tricycle) cyc[2];
		
		downUni.balance();
		downBi.balance();
		//
		// downTri.balance();
		//
		//shows error message because there is no balance method in Tricycle class.
				
	}

}
