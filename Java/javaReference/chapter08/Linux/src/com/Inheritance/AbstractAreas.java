package com.Inheritance;

import java.nio.channels.NonReadableChannelException;

// Using abstract method and classes. 

abstract class Figure {
	double dim1; 
	double dim2;
	
	Figure(double a, double b) {
	    this.dim1 = a;
	    this.dim2 = b;
	}
	
	// area is an abstract method 
	abstract double area();
}

class Rectangle extends Figure{
	public Rectangle(double a, double b) {
		super(a, b);
	}
	
	// override Area for rectangle 
	double area() {
		System.out.println("Inside orea for Rectangle: ");
		return dim1*dim2;
	}
}

class Triangle extends Figure {
	Triangle(double a, double b) {
		super(a, b);
	}

	// override area for right triangle
	double area() {
		System.out.println("Inside Area for Triangle.");
		return dim1 * dim2 / 2;
	}
}


public class AbstractAreas {

	public static void main(String[] args) {
		// Figure figure = new Figure(10, 10); illegal now 
		Rectangle r = new Rectangle(9, 5);
		Triangle t = new Triangle(10, 8);
		Figure figref; 
		figref = r;
		System.out.println("Area is " + figref.area());
		figref = t; 
		System.out.println("Area is " + figref.area());
			
	}

}
 