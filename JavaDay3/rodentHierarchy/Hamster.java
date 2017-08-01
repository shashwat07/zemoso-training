package rodentHierarchy;

abstract class Hamster extends Rodent{
	
	Hamster(){
		System.out.println("Hello, I am a Hamster!");
	}

	abstract void favFood();

	abstract void mySize();

}
