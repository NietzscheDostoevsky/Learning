package linkedList;

import java.util.LinkedList;

public class LinkedListDemo {
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		ll.addFirst(10);
		ll.addFirst(20);
		ll.addFirst(30);
		ll.addFirst(40);
		ll.addLast(50);
		System.out.println(ll);		
		ll.removeFirst();
		System.out.println(ll);
		
	}

}
