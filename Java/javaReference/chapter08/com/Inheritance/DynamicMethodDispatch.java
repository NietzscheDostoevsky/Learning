package com.Inheritance;

class A3 {
	void callme() {
		System.out.println("Inside A's callme method");
	}
}

class B3 extends A3 {
	// override callme();
	void callme() {
		System.out.println("Inside B's callme method");
	}
}

class C3 extends A3 {
	// override callme();
	void callme() {
		System.out.println("Inside C's callme method");
	}
}

public class DynamicMethodDispatch {
	public static void main(String[] args) {
		A3 a = new A3(); 
		B3 b = new B3();
		C3 c = new C3();
		
		A3 r; // reference of type A3
		r = a ;
		r.callme();
		
		r = b; // b3
		r.callme();
		
		r = c; // c3
		r.callme();
	}
	
}
