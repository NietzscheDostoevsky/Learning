package linkedListImplementation;

public class MyLinkedList<E> {
	
	Node<E> head; 
	Node<E> tail;
	int count = 0; 
	
	@Override
    public String toString() {
        if (head == null) {
            return "[]";
        }
        Node<E> currNode = head;
        StringBuilder op = new StringBuilder("[ ");
        while (currNode != null) { 
            op.append(currNode.e);
            if (currNode.next != null) {  
                op.append(", ");
            }
            currNode = currNode.next; 
        }
        op.append(" ]");
        return op.toString();
    }
	
	private class Node<E> {
		E e; 
		Node<E> next = null;
		public Node(E e) {
			this.e = e; 
		}
	}
	
	public void addLast(E e) {
		Node<E> newNode = new Node<>(e);
		if(head == null) {
			head = newNode; 
		} else {
			Node<E> currNode = head; 
			while(currNode.next != null) {
				currNode = currNode.next; 
			}
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
	}

}























