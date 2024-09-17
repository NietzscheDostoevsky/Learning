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
		
		// More examples. 
		
		// 1. summing integers with reduce
		List<Integer> numbers = Arrays.asList(1,2,3,4,5);
		System.out.println("Sum of numbers: " + numbers.stream().reduce(0, (a,b) -> a + b));
		
		// 2. Concatenating Strings with reduce
		List<String> words = Arrays.asList("Different", "combination", "of", "words");
		System.out.println("Combined: " + words.stream().reduce("", (a,b) -> a + " " + b));
		
		// 3. Finding the Maximum Value with reduce
		numbers = Arrays.asList(5, 3, 8, 2, 9);
		Optional<Integer> max = numbers.stream().reduce((a,b) -> a>b ? a:b); 
		if (max.isPresent())
			System.out.println("Max in " + numbers + " :" + max.get());
		
		// 4. Product of only even values. 
		numbers = Arrays.asList(7,18,10,24,17,5);
		System.out.println("Even product: " + numbers.stream().filter(a->a%2==0).reduce(1, (a,b) -> a*b));
		System.out.println("Even product: " + numbers.stream().reduce(1, (a,b) -> b%2==0 ? a*b:a));
		System.out.println("Odd  product: " + numbers.stream().reduce(1, (a,b) -> b%2 !=0 ? a*b:a));
		System.out.println("Odd  product: " + numbers.stream().reduce(1, (a,b) -> b%2==0 ? a:a*b));
	}
}
