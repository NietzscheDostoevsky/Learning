package com.Inheritance;

// Demostrate when concstructors are executetd 

// creating a superclass

class A {
	A() {
	System.out.println("Inside A's constructior");
	}
}

// subclass by extending a 
class B extends A {
	B() {
		System.out.println("Inside B's constructor");
	}
}

class C extends B {
	public C() {
		System.out.println("Inside C's constructor ");
	}
}

public class ConstructionExecutionOrder {

	public static void main(String[] args) {
		
		C c = new C(); 

	}

}
