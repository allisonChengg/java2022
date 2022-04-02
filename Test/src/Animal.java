
public class Animal {
	public void walk() {
		System.out.println("Animal Walk");
	}
}

class Canine extends Animal {
	
}

class Dog extends Canine {
	public void walk() {
		System.out.println("Dog Walk");
	}
}