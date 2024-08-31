package genericClassHierarchies;

class GenA<T> {
	T objT;
	
	GenA(T o){
		this.objT = o;
	}
	
	T getOb() {
		return this.objT;
	}
}

class GenB<T> extends GenA<T> {
	GenB(T o){
		super(o);
	}
}

//Demostrating run-time type ID implications of generic class hierarchy. 
public class HierDemoRuntimeTypeComparisons {
	public static void main(String[] args) {
		
		//Create a GenA object for Integers 
		GenA<Integer> iOb = new GenA<>(73);
		
		// create a GenB object for Integers. 
		GenB<Integer> iOb2 = new GenB<>(37); 
		
		// Create a Gen2 object for Strings.
		GenB<String> strOb2 = new GenB<String>("Generics Test");
		
		// See if iOb2 is somr form of GenB
		if (iOb2 instanceof GenB<?>)
			System.out.println("iOb2 is a instance of GenB");
		if (iOb2 instanceof GenA<?>)
			System.out.println("iOb2 is a instance of GenA");
		
		System.out.println();
		
		if(strOb2 instanceof GenB<?>)
			System.out.println("strob2 is isntage of GenB");
		
		if(strOb2 instanceof GenA<?>)
			System.out.println("strob2 is instance of GenA");
		
		System.out.println();
		
		// see if iOb is an instance of Gen2, which it is NOT. 
		if(iOb instanceof GenB<?>)
			System.out.println("iOb is instance of GenB");
		
		if(iOb instanceof GenA<?>)
			System.out.println("iob is instance of GenA");
		
		
		
	}
}



















