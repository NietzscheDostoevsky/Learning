package iterator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.RandomAccess;
import java.util.function.BiFunction;

public class RandomAccessInterfaceDemo {
	public static void main(String[] args) {
		ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList("A", "B", "C", "D"));
		LinkedList<String> linkedList = new LinkedList<String>(Arrays.asList("E", "F", "G", "H"));

		printList(arrayList);
		printList(linkedList);
		

	}

	public static void printList(List<String> list) {
		if (list instanceof RandomAccess) {
			System.out.println("using for loop for random access list");
			for (int i = 0; i < list.size(); i++)
				System.out.println(list.get(i));
		} else {
			System.out.println("Using iterator for non-RandomAccess list:");
			Iterator<String> itr = list.iterator();
			while (itr.hasNext()) {
				System.out.println(itr.next());
			}
		}
	}
}
