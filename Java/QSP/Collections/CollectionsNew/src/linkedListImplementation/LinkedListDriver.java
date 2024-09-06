package linkedListImplementation;


public class LinkedListDriver {

	public static void main(String[] args) {
		
		
		MyLinkedList<Integer> list = new MyLinkedList<>();
		System.out.println(list);
		list.addLast(10);
		list.addLast(20);
		list.addLast(30);
		list.addLast(40);
		list.addLast(50);
		list.addLast(60);
		list.addFirst(90000);
		System.out.println(list);
		System.out.println(list.removeFirst());
		System.out.println(list);
		System.out.println(list.size());
		System.out.println(list.getFirst());
		System.out.println(list.removeLast());
		System.out.println(list.getLast());	
		System.out.println(list.size());
		System.out.println(list);
		list.remove(2);
		System.out.println(list);
		
	}

}