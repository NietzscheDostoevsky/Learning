package LambdaExpressionExamples;

// A block lambda that ocmputers the factorial of an int value. 

@FunctionalInterface
interface NumericFunc {
	int func(int n);
}

public class BlockLambdaDemo {

	public static void main(String[] args) {
		
		
		// This block lambda computes the factorial of an int value. 
		NumericFunc factorial = (n) -> {
			int result = 1; 
			for (int i = 1; i <=n; i++)
				result = i * result; 
			return result; 
		};
		
		System.out.println(String.format("The factorial of 3 is: %d", factorial.func(3)));
		System.out.println(String.format("The factorial of 5 is: %d", factorial.func(5)));

	}

}
