package stack;

import java.util.Arrays;
import java.util.EmptyStackException;

// Stack implementation using 

public class MyStack<E> {
	E[] arr ; 
	int indx; 
	@SuppressWarnings("unchecked")
	MyStack() {
		arr = (E[]) new Object[10];
	}
	
	public E push(E e) {
		if(arr.length == indx)
			arr = Arrays.copyOf(arr, (arr.length*2));
		
		arr[indx++] = e; 
		return e; 
	}
	
	@Override
	public String toString() {
		if(indx == 0)
			return "[]";
		
		String op = "["; 
		for (int i = 0; i < indx - 1; i++)
			op += arr[i] + ",";
		op += arr[indx-1] + "]";
		return op;
	}
	
	public synchronized E pop() {
		if (indx == 0)
			throw new EmptyStackException();
		E e = arr[indx -1]; 
		arr[indx-1] = null;
		indx--;
		return e; 
	}
	
	public synchronized E peek() {
		return arr[indx-1];
	}
	
	public boolean empty() {
		if (indx==0)
			return true; 
		return false; 
	}
	
	public synchronized int search(E e) {
		int offset = 1; 
		for (int i = indx; i>=0; i--) {
			if (e.equals(arr[i]))
				return offset++;
			offset++;
		}
		return -1; 
	}
}
