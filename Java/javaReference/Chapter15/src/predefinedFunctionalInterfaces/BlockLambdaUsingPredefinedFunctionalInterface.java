package predefinedFunctionalInterfaces;

import java.util.function.Function;

public class BlockLambdaUsingPredefinedFunctionalInterface {
	public static void main(String[] args) {
		
		//This block lambda computes the factorial of an int value. 
		// Funciton is an functional interface. 
		
		Function<Integer, Integer> factorial = (n) -> {
			int result = 1; 
			for (int i = 1; i <=n; i++)
				result *= i; 
			return result;
		};
		
		System.out.println(String.format("The factorial of 3 is: %d", factorial.apply(3)));
		System.out.println(String.format("The factorial of 5 is: %d", factorial.apply(5)));
	}
}
