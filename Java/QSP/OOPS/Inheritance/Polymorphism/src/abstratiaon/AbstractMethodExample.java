package abstratiaon;

abstract class Parent1 {
	void m1() {
		System.out.println("Hello from parent");
	}
	
	abstract void m2(); 
}

class Child1 extends Parent1 {
	void m2() {
		System.out.println("Hello from Child 1");
	}
}

class Child2 extends Parent1 {
	void m2() {
		System.out.println("Hello from Child 2");
	}
}

public class AbstractMethodExample {
	public static void main(String[] args) {
		
		Child1 c1= new Child1();
		Child2 c2 = new Child2(); 
		
		c1.m2();
		c2.m2(); 
		
	}
}
