package obtainStream;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Stream;

public class SimpleStreamDemo {
	public static void main(String[] args) {
		ArrayList<Integer> myList = new ArrayList<Integer>();
		myList.add(7);
		myList.add(18);
		myList.add(10);
		myList.add(24);
		myList.add(17);
		myList.add(5);

		System.out.println("Original List : " + myList);

		// Obtaining a stream of ArrayList
		Stream<Integer> myStream = myList.stream();

		// Obtaining the max and min values.
		Optional<Integer> minVal = myStream.min(Integer::compare);
		if (minVal.isPresent())
			System.out.println("Min val: " + minVal.get());

		// Must obtain a new stream because the previous operation was a terminal
		// operation
		// so it consumed the stream.
		myStream = myList.stream();
		Optional<Integer> maxVal = myStream.max(Integer::compare);
		if (maxVal.isPresent())
			System.out.println("Max val: " + maxVal.get());

		// My Logic
		System.out.println(myList.stream().min(Integer::compare).get());
		System.out.println(myList.stream().max((e1, e2) -> e1 - e2).get());

		// Sort the stream by use of sorted().
		Stream<Integer> sortedStream = myList.stream().sorted();
		System.out.print("Sorted list: ");
		sortedStream.forEach((n) -> System.out.print(n + " "));
		System.out.println();

		// My logic
		System.out.println("Sorted list ascending: ");
		myList.stream().sorted().forEach(System.out::println);
		System.out.println("Sorted list descending: ");
		myList.stream().sorted((e1, e2) -> e2 - e1).forEach(System.out::println);

		// Display only the odd values by use of filter().
		Stream<Integer> oddVals = myList.stream().sorted().filter(n -> n % 2 == 1);
		System.out.print("Odd Values: ");
		oddVals.forEach((n) -> System.out.print(n + " "));
		System.out.println();

		// My Logic
		System.out.println("Even values: ");
		myList.stream().sorted().filter(x -> x % 2 == 0).forEach(System.out::println);

		// display onlly the odd values that are greater than 5.
		// two filters have to be used in pipeline.
		oddVals = myList.stream().filter(n -> n % 2 == 1).filter(n -> n > 5);
		System.out.print("Odd vals greater than 5: ");
		oddVals.forEach(n -> System.out.print(n + " "));
		System.out.println();

		// My logic
		// even vals greater than 10
		System.out.println("Even vals greater than 10");
		myList.stream().sorted().filter(n -> n % 2 == 0).filter(n -> n > 10).forEach(System.out::println);
	}
}
