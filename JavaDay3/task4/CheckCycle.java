package task4;

public class CheckCycle {
	
	public static void main(String args[]){
		CycleFactory cf = new CycleFactory();
		
		cf.getCycle(1).wheels(); // Calling cycle with 1 wheel
		cf.getCycle(2).wheels(); // Calling cycle with 2 wheels
		cf.getCycle(3).wheels(); // Calling cycle with 3 wheels
		
	}

}
