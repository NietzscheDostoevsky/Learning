package LambdaExpressionExamples;

// A block lambda that reverses the characters of a string. 

@FunctionalInterface
interface StringFunc {
	String func(String n);
}

public class BlockLambdaDemo2 {

	public static void main(String[] args) {
		
		// This block lambda reverses the characters in a string; 
		StringFunc reverse = (str) -> {
			String result = ""; 
			int i;
			
			for (i = str.length()-1; i >= 0; i--)
				result += str.charAt(i); 
			return result; 
		};
		
		System.out.println(String.format("Lambda reversed is: %s", reverse.func("Lambda")));
		System.out.println(String.format("Expression reversed is: %s", reverse.func("Expression")));
	}
}
