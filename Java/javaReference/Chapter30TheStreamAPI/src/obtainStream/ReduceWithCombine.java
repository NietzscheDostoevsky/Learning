package obtainStream;

import java.util.Arrays;
import java.util.List;

public class ReduceWithCombine {
	public static void main(String[] args) {
		
		List<Double> myList = Arrays.asList(7.0, 18.0, 10.0, 24.0, 17.0, 5.0);
		
		double prodOfSquareRoots = myList.parallelStream().reduce(1.0, (a,b) -> a*Math.sqrt(b), (a,b)->a*b);
		System.out.println("Product of square roots: " + prodOfSquareRoots);
		System.out.println(myList.stream().reduce(1.0, (a,b) -> a * Math.sqrt(b)));
	}
}
