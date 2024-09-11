package stack;

public class MyStackLinkedList<E> {
	private Node first; // top of the stack 
	private int count; // number of items. 
	
	private class Node {
		E e; 
		Node next; // reference to the next node. 
	}
	
	public void push(E e) {
		Node oldFirst = first; 
		first = new Node(); 
		first.e = e; 
		first.next = oldFirst; 
		
	}
	
	
}
