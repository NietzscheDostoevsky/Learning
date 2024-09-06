package linkedListImplementation;

//--------------------------------------
// SINGLY LINKED-LIST IMPLEMENTATION
//--------------------------------------

public class MyLinkedList<E> {
	
	Node<E> head; 
	Node<E> tail;
	int count = 0; 
	
	
	private class Node<E> {
		E e; // data. 
		Node<E> next = null; // next node. 
		public Node(E e) {
			this.e = e; 
		}
	}
	
	@Override
    public String toString() {
        if (head == null) return "[]";
        
        Node<E> currNode = head;
        StringBuilder op = new StringBuilder("[ ");
        while (currNode != null) { 
            op.append(currNode.e);
            if (currNode.next != null) op.append(", ");
            currNode = currNode.next; 
        }
        op.append(" ]");
        return op.toString();
    }
	
	
	// add element at the last of the LL
	public void addLast(E e) {
		Node<E> newNode = new Node<>(e);
		tail = newNode; 
		if(head == null) {
			head = newNode; 
		} else {
			Node<E> currNode = head; 
			while(currNode.next != null) 
				currNode = currNode.next; 
			currNode.next = newNode; 
		}
		count++;
	}
	
	public void addFirst(E e) {
		Node<E> newNode = new Node<E>(e); 
		if(head == null) {
			head = newNode;			
		} else {
			newNode.next = head; 
			head = newNode; 
		}
		count++;
	}
	
	public E getFirst() {
		return head.e;
	}
	
	public E getLast() {
		return tail.e; 
	}
	
	public E removeFirst() {
		if (head == null) throw new IllegalArgumentException();
		E dup = head.e; 
		head = head.next; 
		count--;
		return dup; 
		
	}
	
	public E removeLast() {
		Node<E> currentNode = head; 
		for (int i = 0; i < size() -2; i++)
			currentNode = currentNode.next; 
		
		Node<E> removedNode = currentNode.next;
		tail = currentNode; 
		currentNode.next = null; 
		count--; 
		return removedNode.e; 
	}
	
	public E remove(int index) {
		Node<E> currentNode1 = head; 
		Node<E> currentNode2 = null; 
		for (int i = 0; i < index-1; i++) 
			currentNode1 = currentNode1.next; 
		currentNode2 = currentNode1.next; 
		currentNode1.next = currentNode2.next; 
		count--;
		return currentNode2.e; 
		
	}

	
	public int size() {
		return count; 
	}
}