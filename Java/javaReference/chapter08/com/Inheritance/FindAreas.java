package com.Inheritance;

// Demostrating runtime polymorphism 

class Figure {
	double dim1;
	double dim2;

	Figure(double dim1, double dim2) { // constructor
		this.dim1 = dim1;
		this.dim2 = dim2;
	}

	double area() {// returns ara of the figure
		System.out.println("Area of the figure is undefined");
		return 0;
	}
}

class Rectangle extends Figure {
	Rectangle(double a, double b) {
		super(a, b);
	}

	// override area for rectangle
	double area() {
		System.out.println("Inside Area for Rectangle.");
		return dim1 * dim2;
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

public class FindAreas {
	
	public static void main(String[] args) {
		Figure f = new Figure(10,10);
		Rectangle r = new Rectangle(9,5);
		Triangle t = new Triangle(10, 8);
		
		Figure figref;
		
		figref = r;
		System.out.println("Area is " + figref.area());
		
		figref = t;
		System.out.println("Area is " + figref.area());
				
		figref = f;
		System.out.println("Area is " + figref.area());
		
		
	}

}
