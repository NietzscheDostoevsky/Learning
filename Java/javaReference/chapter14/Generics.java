// A simple generic class. 
// Here, T is a type paramete that 
// will be replaces by a eral type
// when an object of type Gen isncreated. 

class Gen<T> {
	T ob ; // declare an object of type T 

	// pass the constructor refefrence to 
	// an object of type T. 

	Gen(T o) {
		ob = o;
	}
	// return ob 
	T getOb() {
		return ob;
	} 
	
	// show type of T . 
	
	void showType() {
		System.out.println("Type of T is " + ob.getClass().getName());
	}
} 

// Demonstrating the generic class using Generic Driver 

class GenericDriver {
	public static void main(String[] args) {
		// Creating a Gen reference of integers 
		Gen<Integer> iOb; 

		// Create a Gen<Inteer> object and assign its \
		// reference to iOb. Notice the use of autoboxing 
		// to encapsulate the value of 88 withing an Integer object. 

		iOb = new Gen<Integer>(88) ; 

		// showing the ytpe of object iOb. 
		iOb.showType();

		// getting the value in IOb. No type cast is needed. 
		int v = iOb.getOb();
		System.out.println("value: " + v);
		System.out.println();

		// createa  gen object for Strings. 
		Gen<String> strOb = new Gen<String> ("Generic Test");

		strOb.showType();
		String str = strOb.getOb(); // no type cast needed. 
		System.out.println("Value: " + str);
	}
}


		
