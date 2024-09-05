package methodReferences;

// Demonstrate a method reference to an instance method. 

//A functional interface for String operations.

@FunctionalInterface
interface StringFunc1 {
	String func(String n);
}

// Now, this class defines an instance method called strReverse(). 
class MyStringOps1 {
	String strReverse(String str) {
		String resultString = "";
		for (int i = str.length()-1; i >=0; i--)
			resultString += str.charAt(i);
		return resultString;
	}
}

public class MethodReferencetToInstanceMethods {

	//This method has a functional interface as the type of 
	//its first parameter. Thus, it can be passed any instance
	// of that interface, including method references. 
	static String stringOp(StringFunc1 sf, String s) {
		return sf.func(s);
	}
	
	public static void main(String[] args) {
		String inString = "Lambdas are POWERFUL";
		String outString ;
		
		// Create a MyStringOps1 object. 
		MyStringOps1 strOps = new MyStringOps1();
		
		//NOw a method refernce to the instance method strReverse is 
		// passed to stringOp
		outString = stringOp(strOps::strReverse, inString);
		
		System.out.println("OG string: " + inString);
		System.out.println("Dupe strg: " + outString);
	}

}
