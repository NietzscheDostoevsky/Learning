package mapping;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

// The flatMap() function is used in Java streams to flatten nested structures. 
// It is especially useful when you have a stream of collections 
// or arrays and you want to transform it into a single continuous stream of elements, 
// rather than a stream of streams.

// The flat map methods are designed to handle situations 
// in which each element in the original stream is mapped to more than one element
// in the resulting stream. 

public class FlatMap {
	public static void main(String[] args) {
		List<List<String>> namesList = Arrays.asList(
				Arrays.asList("John", "Jane"), 
				Arrays.asList("Tom", "Jerry"),
				Arrays.asList("Anna", "Elsa")
		);
		
		System.out.println("OG list" + namesList);
		
		// using map()
		Stream<Stream<String>> streamOfStreams = namesList.stream().map(List::stream);
		streamOfStreams.forEach(s -> s.forEach(System.out::println));
		System.out.println();
		// using flatMap()
		Stream<String> flatStream = namesList.stream().flatMap(List::stream);
		flatStream.forEach(System.out::println);
	}
}
