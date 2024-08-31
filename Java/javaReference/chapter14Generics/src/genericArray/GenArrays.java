package genericArray;

//Generics and Arrays

class Gen<T extends Number> {
	T ob;
	T[] vals; // Okay
	
	Gen(T o, T[] nums) {
		this.ob = o;
		
		//this statement is illegal
		//vals = new T[10];
		
		//But this statement is okay
		vals = nums; // ikay to assign reference to an existing array
	}
}

public class GenArrays {
	public static void main(String[] args) {
		Integer[] n = { 1,2,3,4,5};
		Gen<Integer> iOb = new Gen<Integer>(30, n); 
		
		// Can't create an array of type-specific generic references. 
		//Gen<Integer>[] gens = new Gen<Integer>[10]; // werong!!! 
		
		// This is okay
		Gen<?>[] gens = new Gen<?>[10];
		System.out.println(gens);
	}
	
}
