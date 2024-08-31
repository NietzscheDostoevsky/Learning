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

public class GenDemo {

	public static void main(String[] args) {

	}

}
