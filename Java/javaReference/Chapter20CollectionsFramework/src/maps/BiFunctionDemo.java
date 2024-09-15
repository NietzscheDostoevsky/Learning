package maps;

import java.util.function.BiFunction;
import java.util.function.Function;

public class BiFunctionDemo {
	public static void main(String[] args) {
		
		
		BiFunction<Integer, Integer, Integer> add = (a,b) -> a + b ;
		Function<Integer, Integer> doubleResult = result -> result * 2; 
		
		//Combining them using andThen(); 
		BiFunction<Integer, Integer, Integer> addAndDouble = add.andThen(doubleResult);
		int result = addAndDouble.apply(7, 3);
		System.out.println(result);
	}
}
