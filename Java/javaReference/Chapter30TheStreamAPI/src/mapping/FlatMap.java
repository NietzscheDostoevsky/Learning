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
		
		// using flatMap(), eliminates the need to iterate over substreams. 
		Stream<String> flatStream = namesList.stream().flatMap(List::stream);
		flatStream.forEach(System.out::println);
		System.out.println();
		
		// flatMap() example for words in sentences. 
		// using flatMap() to split sentences into words and process each word. 
		
		List<String> sentences = Arrays.asList(
				"Hello world", 
				"How are you",
				"Java streams are POWERFUL"
		);
		System.out.println(sentences.size());
		
		sentences.stream()
				 .flatMap(sentence -> Arrays.stream(sentence.split(" ")))
				 .map(word->word.toUpperCase())
				 .forEach(System.out::println);
		
		// Arrays.stream(sentence.split(" ")) splits each sentence into words and 
		//	returns a stream of words for each sentence.
		
		// flatMap() takes care of flattening all the individual streams of words into a single stream.
		
		
		//Equivalent code as above, but according to chatGPT flatmap version is better. 
		// And contains a nested forEach inside a forEach, which is bad practice in computing. 
		System.out.println();
		sentences.forEach(sentence -> {
			Arrays.stream(sentence.split(" "))
				  .map(word->word.toUpperCase())
				  .forEach(System.out::println);
		});
		
		
		System.out.println();
		// Equivalent imperetive code : 
		for (String sentence: sentences) {
			String[] words = sentence.split(" ");
			for (String word: words) {
				System.out.println(word.toLowerCase());
			}
		}
	}
}












































