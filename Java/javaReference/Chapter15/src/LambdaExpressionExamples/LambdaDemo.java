package LambdaExpressionExamples;

// Demostrating lambda expressoin 

// a functional interface. 

@FunctionalInterface
interface MyNumber {
	double getValue(); 
}

public class LambdaDemo {

	public static void main(String[] args) {
		MyNumber myNum; // declare an interface reference.
		
		// Here, the lambda expressoni is simple a constant expression. 
		// When it si asssigned to MyNum, a class instance is 
		// cnostructed in which the lambda expression implemetes 
		// the getValue() method in myNumber . 
		
		myNum = () -> 123.45; 
		
		// Calling getValue(), which is provided by the previously assigned
		// lambda expression 
		
		System.out.println("A fixed value: " + myNum.getValue());
		myNum = () -> Math.random() * 100; 
		System.out.println("A random value: " + myNum.getValue());
		System.out.println("Another random value: " + myNum.getValue());
		
		// a lambda expression must be compatible with the method
		// defined by the functional interface. 
		// the following lines won't work 
		// myNum = () -> "123.03"; // CTE
		
	}

}
