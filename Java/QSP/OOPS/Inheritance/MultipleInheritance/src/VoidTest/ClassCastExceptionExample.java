package VoidTest;

public class ClassCastExceptionExample {
	
	Vegetable vv ;  
	public static void main(String[] args) {
//		Vegetable v = new Brinjal(); // upcasting 
//		v.m1(); 
//		//v.m2(); // CTE 
//		Brinjal b = (Brinjal) v; 
//		b.m2(); 
//		b.m1();
//		System.out.println("HEHE");
//		ClassCastExceptionExample c = new ClassCastExceptionExample(); 
//		
//		Brinjal bb = (Brinjal) c.vv; 
//		System.out.println("HAHA");
//		
//		bb.m1(); 
//		bb.m2(); 
		
		Vegetable vv  = new Carrot(); 
		Brinjal bb = (Brinjal) vv; 
		
		
		
		
		
		
		
		
		
	}
}

class Vegetable {
	int quantity = 2; 
	public void m1() {
		System.out.println(quantity);
	}
}

class Brinjal extends Vegetable {
	double price = 44.2; 
	public void m2() {
		System.out.println(price);
		System.out.println("Brinjal method executed");
	}
}

class Carrot extends Vegetable {
	double price2 = 323.232;
	public void m3() {
		System.out.println(price2);
		System.out.println("Carrot method executed");
	}
}