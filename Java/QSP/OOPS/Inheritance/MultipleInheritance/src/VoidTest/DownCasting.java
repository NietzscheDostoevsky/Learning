package VoidTest;

public class DownCasting {
	public static void main(String[] args) {
		
		Fruit 
		Apple a = (Apple) f; 
		System.out.println("It ran");
	}
}

class Fruit {
	String name ; 
	void m1() {
		System.out.println(name);
	}
}

class Apple extends Fruit {
	String name ; 
	void m2() {
		System.out.println(name);
	}
}

class Mango extends Fruit {
	String name; 
	void m3() {
		System.out.println(name);
	}
}
