package parallel;

import java.util.LinkedList;

public class ParallelTestingLinkedList {
	public static void main(String[] args) {
		
		// Create a large array. 
		
		Stopwatch timer = new Stopwatch();
		
		int size = 10_000_00;
		LinkedList<Double> list1 = new LinkedList<>();
		
		for (int i = 0; i < size; i++)
			list1.add(i+0.0);
		System.out.println(list1.size());
		System.out.println("List1 : " + timer.elapsedTime());
		
		timer = new Stopwatch();
		LinkedList<Double> list2 = new LinkedList<>();
		for (var i : list1) {
			list2.add(i * 2.0 + 1) ; 
		}
		System.out.println("List2 : " + timer.elapsedTime());
		
		timer = new Stopwatch();
		LinkedList<Double> list3 = list1.stream()
										 .map(a->Math.sqrt(a) + 1)
										 .collect(LinkedList::new, LinkedList::add, LinkedList::addAll);
		System.out.println("List3 : " + timer.elapsedTime());
		
		timer = new Stopwatch();
		LinkedList<Double> list4 = list1.parallelStream()
										 .map(a->Math.sqrt(a) + 1)
										 .collect(LinkedList::new, LinkedList::add, LinkedList::addAll);
		System.out.println("List4 : " + timer.elapsedTime());
		
	}
}
