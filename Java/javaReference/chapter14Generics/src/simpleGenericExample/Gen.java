package simpleGenericExample;

// a simple generic class. 
// T is a type parameter that will be replaced by 
// 	 a real type when an object of type Gen is creaetd. 

class Gen<Type> {
	Type objT ; // declare an object of type T 
	
	// passing the constructor a reference to an object of 
	// 		type T 
	
	public Gen(Type objT) {
		this.objT = objT; 
	}
	
	// returning an object of type T. 
	
	Type getObj() {
		return objT; 
	}
	
	// show the type of T. 
	
	public void showType() {
		System.out.println("Type of T is : " + objT.getClass().getName());
	}
}
 