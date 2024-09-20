package iterators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Spliterator;
import java.util.stream.Stream;

public class SplitIteratorDemo {
	public static void main(String[] args)  {
		
		ArrayList<String> myList = new ArrayList<String>(Arrays.asList("Alpha", "Beta", "Gamma", "Delta","Phi", "Omega"));
		
		Stream<String> myStream = myList.stream();
		Spliterator<String> spliterator = myStream.spliterator();
		Spliterator<String> spliterator2 = spliterator.trySplit();
		
		if (spliterator2 != null) {
			System.out.println("output from 2:  ");
			spliterator2.forEachRemaining(System.out::println);
		}
		
		System.out.println("output from 1: ");
		spliterator.forEachRemaining(System.out::println);
		
		
	}
}
