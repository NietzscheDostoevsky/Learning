package abstratiaon;

abstract class Parent3 {
	abstract void m1(); 
}

abstract class Child3 extends Parent3 {
	abstract void m2(); 
	public void m1() {
		System.out.println("Implementation to parent abstract m1()");
	}
}

class SubChild extends Child3 {
	public void m2() {
		System.out.println("Implementation of child abstract m2()");
	}
}
public class AbstractMethodExample2 {
	public static void main(String[] args) {
		
		SubChild sc = new SubChild(); 
		sc.m1();
		sc.m2();
	}
}
