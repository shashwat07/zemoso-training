package task4;

public class CycleFactory {
	
	public Cycle getCycle(int numWheels){
		if(numWheels == 1){
			return new Unicycle();
		}
		else if (numWheels == 2){
			return new Bicycle();
		}
		else if (numWheels == 3){
			return new Tricycle();
		}
		else{
			return null;
		}
	}

}
