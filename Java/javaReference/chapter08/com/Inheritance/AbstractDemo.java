package com.Inheritance;

// a simple demostration of abstract 

abstract class A5 {
	abstract void callme();

	// concrete methods are allowed in abstract classes.
	void callmetoo() {
		System.out.println("This is a concrete method inside abstract class");
	}
}

class B5 extends A5 {
	void callme() {
		System.out.println("B5's implementation of callme");
	}
}

public class AbstractDemo {

	public static void main(String[] args) {
		B5 b = new B5();
		b.callme();
		b.callmetoo();
	}
}
