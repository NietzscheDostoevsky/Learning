package mapping;

import java.util.Arrays;

public class SumOfSquareRoots {
	public static void main(String[] args) {
		var myList = Arrays.asList(7.0, 18.0, 10.0, 24.0, 17.0, 5.0);
		
		// product of square root using map 
		var prod = myList.stream().map(a->Math.sqrt(a)).reduce((a,b)->a*b);
		System.out.println("Product: " + prod.get());
		
	}
}
