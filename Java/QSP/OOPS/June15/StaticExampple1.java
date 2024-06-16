class StaticExample1{

	// static initializers are executed in top to bottom order  

	public static void main(String[] args) {
		System.out.println("EXECUTION STARTS");
		
	}

	static int a = 10; 
	static{
		System.out.println(a);
	}

	static{
		// static block 
		// will execute once in a life of a class
		// have no access modifiers 
		// doesn't contain any name 
		// executed at the time of class loading process 
		// have no return types, can't accept any input data, can't be invoked. 
		System.out.println("STATIC BLOCK 1");
		// this should be displayed first 
	}

	static{
		System.out.println("STATIC BLOCK 2");
	}
	static{
		System.out.println("STATIC BLOCK 3");
	}

}