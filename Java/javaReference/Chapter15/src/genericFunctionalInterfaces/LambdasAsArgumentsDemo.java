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
		
		// This passes a block lambda that removes spaces. 
		
		outStr = stringOp((str) -> {
			String result = "";
			int i; 
			for(i = 0; i < str.length(); i++)
				if(str.charAt(i) != ' ')
					result += str.charAt(i); 
			return result; 
		}, inStr);
		
		System.out.println("The string with spaces removed: " + outStr);
		
		// Its also possible to pass a StringFunc instance created by an 
		// earlier lambda expression. 
		// Example after the next declaration executes, reverse refers 
		// to an instance of StringFunc. 
		
		StringFunc reverse = (str) -> {
			String result = ""; 
			for (int i = str.length() -1; i >= 0; i--)
				result += str.charAt(i); 
			return result; 
		};
		
		// Now reverse can be passed as the first parameter ot stringOp() 
		// since it refers to a StringFunc object. 
		System.out.println("The string reversed: " +
								stringOp(reverse, inStr));
	}


}
