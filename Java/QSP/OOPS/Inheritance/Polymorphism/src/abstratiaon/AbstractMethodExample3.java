package abstratiaon;

abstract class Parent4 {
	abstract void m1(); 
	abstract void m2();
}

abstract class Child4 extends Parent4 {
	abstract void m3(); 
}

class GrandChild41 extends Child4 {
	 void m1() {
		 
	 }
	 void m2() {
		 
	 }
	 void m3() {
		 
	 }
}

class GrandChild42 extends Child4 {
	void m1() {
		
	}
	void m2() {
		
	}
	void m3() {
		
	}
}

class GrandGrandChild4 extends GrandChild42 {
	void m3() {
		
	}
}
public class AbstractMethodExample3 {

}
