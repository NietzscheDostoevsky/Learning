package rawTypes;

// Demostrate a raw type. 
class Gen<Type> {
	Type objType; // declaring an object of type Type.
	
	// Passing the constructor a reference to the object of type Type
	public Gen(Type obj) {
		this.objType = obj;
	}
	
	// Return obj
	Type getObjType() {
		return objType;
	}
}

// Demostrating raw types. 
public class GenDemo {

	public static void main(String[] args) {
		
		//Create a Gen object for Integers. 
		Gen<Integer> iObj = new Gen<Integer>(88);
		
		//Create a Gen object for Strings
		Gen<String> strObj = new Gen<String>("Testing generics");
		
		// creating a Gen object and give it s double value. 
		Gen raw = new Gen(Double.valueOf(37.73));
		
		//Cast here is necessary because type is unknown. 
		double d = (Double) raw.getObjType();
		
		System.out.println("Value of double: " + d);
		
		// The use of a raw type can lead to run-time
		// exceptions. 
		
		//int i = (Integer) raw.getObjType(); // RTE ClassCastException
		
		//this assignment overrides type safety. 
		strObj = raw; // No error in this line 
		//String str = strObj.getObjType();// error CCE.
		
		raw = iObj; // again, no error here, but type safety can't be ensured. 
		d = (Double) raw.getObjType(); // CCE during runtime.  
		
	}
}




























