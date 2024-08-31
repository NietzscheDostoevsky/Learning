package genericClassHierarchies;


// A subclass can add its own type parameters. 

class Gen<T> {
	T ob; // declaring an object of type T
	
	// Pass the constructor a reference to an object of type T. 
	Gen(T o) {
		this.ob = o; 
	}
	
	// Return ob.
	T getOb() {
		return this.ob;
	}
}

// A subclass of Gen that defines a second type paramter, called V. 
class Gen2<T, V> extends Gen<T> {
	V ob2;
	Gen2(T o, V o2){
		super(o);
		this.ob2 = o2;
	}
	
	V getob2() {
		return ob2;
	}
}

public class HierDemo {

	public static void main(String[] args) {
		//Create a Gen2 object2 for String and Integer
		Gen2<String, Integer> x = new Gen2<String, Integer>("Value is : ", 42);
		System.out.print(x.getOb());
		System.out.println(x.getob2());
	}

}
