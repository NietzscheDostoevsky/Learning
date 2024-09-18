package mapping;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

// Using primitive stream. 

public class PrimitiveMap {
	static List<Double> myList = Arrays.asList(1.1, 3.6, 9.2, 4.7, 12.1, 5.0);
	public static void main(String[] args) {
		System.out.println("Original list: " + myList);
		System.out.println();
		
		// Map the ceiling of the elements in myList to an IntStream. 
		IntStream ceilingStream = myList.stream().mapToInt(a->(int) Math.ceil(a));
		ceilingStream.forEach(PrimitiveMap::printWithSpace);
		
	}
	
	public static void printWithSpace(int num) {
		System.out.print(num + " ");
	}
}
