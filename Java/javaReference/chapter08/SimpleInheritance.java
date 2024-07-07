// a simple example of inheritance 

// crating a superclass 
class A {
	int i, j;
	void showij() {
		System.out.println(" i and j " + i + " " + j);
	}
}

// crating a subclass 
class B extends A {
	int k;
	void showk() {
		System.out.println("k: " + k);
	}

	void sum() {
		System.out.println("i+j+k: " + (i+j+k));
	}
}

class SimpleInheritance {
	public static void main(String[] args) {
		A superOb = new A();
		B subOb = new B();

		superOb.i = 10;
		superOb.j = 20 ; 

		System.out.println("Contents of superOb: "  );
		superOb.showij();
		System.out.println();

		// The subclass has access to all the public memebers
		// of the superclass 

		subOb.i = 7;
		subOb.j = 8; 
		subOb.k = 9;
		// subclass in getting its own copy of i, j different from superOb? 
		System.out.println("Contentes of subOb");
		subOb.showij();
		subOb.showk();
		System.out.println();
		System.out.println("Sum of i, j, k in subOb");
		subOb.sum();

		System.out.println("Contents of superOb: "  );
		superOb.showij();
	}
}