package genericFunctionalInterfaces;

// using lambda expressions as an argument to a method. 

@FunctionalInterface
interface StringFunc {
	String func(String n); 
}
public class LambdasAsArgumentsDemo {
	
	// This method has a functional interface as the type of
	// its first parameter. Thus, it can be passed a reference to 
	// any instance of that interface, including the instance created 
	// by a lambda expression. 
	
	// The second parameter specifies the string to operate on. 
	
	static String stringOp(StringFunc sf, String s) {
		return sf.func(s);
	}
	
	// same thing happens with Comparator interface. 

	public static void main(String[] args) {
		String inStr = "Lambdas add power to Java"; 
		String outStr; 
		
		System.out.println("Here is the input string: " + inStr);
		
		// Here, a simple expression lambda that uppercases a string
		// is passed to stringOp(). 
		
		outStr = stringOp((str) -> str.toUpperCase(), inStr); 
		System.out.println("The string in uppercase: " + outStr);
		

	}

}
