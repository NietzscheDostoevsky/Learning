package selftest;

// Creating a functional interface which reverses a String 
interface StringFunc {
	String func(String str);
}

class MyStringOps {
	 static String stringReverse(String str) {
		 String resultString = "";
		 for (int i = str.length()-1; i >=0; i--)
			 resultString += str.charAt(i);
		 
		 return resultString;		 
	 }
}

public class MethodReferenceToStaticMethods {
	
	static String stringOp(StringFunc sf, String s) {
		return sf.func(s);
	}

	public static void main(String[] args) {
		String inputString = "This is a test";
		String outputString ;
		
		outputString = stringOp(MyStringOps::stringReverse, inputString);
		
		System.out.println("Input: " + inputString);
		System.out.println("Output: " + outputString);
	}

}
