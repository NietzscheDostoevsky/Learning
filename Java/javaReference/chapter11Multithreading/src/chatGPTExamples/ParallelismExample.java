package chatGPTExamples;

import java.util.Arrays;
import java.util.List;

public class ParallelismExample {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		System.out.println(numbers.getClass().getName());
		
		//Parallel stream to process the list in parallel. 
		numbers.parallelStream()
			   .forEach(num -> System.out.println("Processing " + num + " by " + Thread.currentThread().getName()));
	}
}
