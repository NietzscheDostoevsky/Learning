package lambdaExpressionsAndExceptions;

// Throw an exception from a lambda expression

interface DoubleNumericArrayFunc {
	double func(double[] n) throws EmptyArrayException; 
} 

class EmptyArrayException extends Exception {
	EmptyArrayException() {
		super("Array Empty");
	}
}

public class DoubleNumericArrayFunc {
	
	public static void main(String[] args) throws EmptyArrayException{
		double[] values = {1.0, 2.0, 3.0, 4.0}; 

		// This block lambda computes the average of an array of doubles. 

		DoubleNumericArrayFunc average = (n) -> {
			double sum = 0; 
			if(n.length == 0)
				throw new EmptyArrayException(); 

			for (int i = 0; i < n.length ; i++) 
				sum += n[i]; 

			reutn sum / n.length; 
		};

		// This works file
		System.out.println("The average is : " + average.func(values));

		//this would throw an exception  
		System.out.println("The average is : " + average.func(new double[0]));
	}

}
