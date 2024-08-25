package simpleGenericExample;

// functionlality equivalent to Gen
// 		but doesn't uses generics 

public class NonGen {
	Object obj; // obj is now of type object, the superclass of all the classes. 
	
	public NonGen(Object obj) {
		this.obj = obj ; 
	}
	
	Object getObject() {
		return obj; 
	}
	
	void showType() {
		System.out.println("Type of obj is :" + obj.getClass().getName());
	}

}
