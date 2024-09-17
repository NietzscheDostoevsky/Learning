package obtainStream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

// Demonstrating reduce method. 

public class ReductionDemo {
	public static void main(String[] args) {
		// Create a list of Integer values. 
		List<Integer> myList = Arrays.asList(7,18,10,24,17,5);
		
		// Obtaining the integer product of the elements. 
		Optional<Integer> productObj = myList.stream().reduce((a,b) -> a*b);
		if (productObj.isPresent())
			System.out.println("Product as Optional: " + productObj.get());
		
		// Method 2 
		int product = myList.stream().reduce(1, (a,b) -> a*b);
		System.out.println(product);
		
		// own practice/ 
		
		System.out.println("Product: " + myList.stream().reduce(1, (a,b) -> a*b));
	}
}
