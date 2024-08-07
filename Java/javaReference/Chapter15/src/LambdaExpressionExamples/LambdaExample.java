package LambdaExpressionExamples;

import java.util.Arrays;
import java.util.List; 
import java.util.function.Predicate;

public class LambdaExample {

	public static void main(String[] args) {
		List<String> names = Arrays.asList("Saurabh", "Singh", "Is", "Great"); 
		
		Predicate<String> startsWithS = (name) -> name.startsWith("S");
		names.stream()
			.filter(startsWithS)
			.forEach(System.out::println); 
	}
}
