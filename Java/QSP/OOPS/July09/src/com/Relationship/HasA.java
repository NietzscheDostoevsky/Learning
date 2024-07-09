package com.Relationship;

class Parent {
	String name = "RAMESH";
	String dob = "01/01/1990";
	
	void displayParent() {
		System.out.println("*** PARENT DETAILS ***");
		System.out.println("Name: : " + this.name);
		System.out.println("DOB: " + this.dob);
	}
	
	// child member must be created implicitely inside parent class 
	// we create an instance of the child class inside parent
	// when we create an object of parent class, the child could be created indrectly
	// thisis how we implement has-a relationshiop 
	// also called COMPOSITION 
	
	Child obj2 = new Child();
	
}

class Child {
	String name = "CHINTU";
	String dob = "01/01/2020";
	
	void displayChild() {
		System.out.println("*** CHILD DETAILS ***");
		System.out.println("Name: : " + this.name);
		System.out.println("DOB: " + this.dob);
	}
}

public class HasA {
	
	public static void main(String[] args) {
		Parent obj = new Parent();
		obj.displayParent();
		obj.obj2.displayChild();

	}
}
