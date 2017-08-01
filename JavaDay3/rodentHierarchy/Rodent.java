package rodentHierarchy;

public abstract class Rodent {

	Rodent(){
		System.out.println("Hi, I am some rodent!");
	}
	
	abstract void favFood();
	abstract void mySize();
	
	public static void main(String args[]){
		
		Rodent rodentList[] = new Rodent[4];
		

		
		rodentList[0] = new Mouse();
		rodentList[0].favFood();
		rodentList[0].mySize();
		
		rodentList[1] = new Gerbil();
		rodentList[1].favFood();
		rodentList[1].mySize();
		
		rodentList[2] = new ChineseHamster();
		rodentList[2].favFood();
		rodentList[2].mySize();
		
		rodentList[3] = new Roborovski();
		rodentList[3].favFood();
		rodentList[3].mySize();
		
		
		
		
		
	}
	

}
