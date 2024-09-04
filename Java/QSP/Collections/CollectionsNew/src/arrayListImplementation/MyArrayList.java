package arrayListImplementation;

import java.util.Arrays;
import java.util.Collection;

public class MyArrayList<E>  {
	
	E[] arr ;
	int indx = 0;
	@SuppressWarnings("unchecked")
	public MyArrayList() {
		arr = (E[]) new Object[10]; 
	}
	
	@SuppressWarnings("unchecked")
	public MyArrayList(int size) {
		arr = (E[]) new Object[size]; 
	}
	
	
	@Override
	public String toString() {
		if(arr[0] == null)
			return "[ ]";
		String op = "[" ; 
		for (int i = 0; i < indx-1; i++) 
			op += arr[i] + ", " ;
		op += arr[indx-1] + "]";
		return op;
	}

	// method to add elements inside an ArrayList 
	
	public void add(E e) {
		if (arr.length == indx) {
			int newSize = (((arr.length) * 3 ) / 2 ) +1; 
			E[] narr = Arrays.copyOf(arr, newSize);
			arr = narr;			
		}
		
		arr[indx++] = (E) e; 
	}
	
	public int indexOf(E e) {
		for (int i = 0; i < size(); i++) 
			if (arr[i].equals(e))
				return i;
		return -1;
	}
	
	public int lastIndexOf(E e) {
		for (int i = size() -1; i >=1; i--) 
			if (arr[i].equals(e))
				return i;
		
		return -1;
	}
	
	public int size() {
		return indx;
	}
	
	public E get(int index) {
		if (index<0 || index>= size()) 
			throw new IndexOutOfBoundsException("Wrong Index Entered");
		return arr[index];
	}
	
	public void trimToSize() {
		E[] narr = Arrays.copyOf(arr, size());
		arr = narr; 
	}
	
	public E set(int index, E ele) {
		if (index<0 || index>= size()) 
			throw new IndexOutOfBoundsException("Wrong Index Entered");
		
		E previousElement = arr[index];
		arr[index] = ele;
		return previousElement;
	}
	
	public void remove(int index) {
		@SuppressWarnings("unchecked")
		E[] narr = (E[]) new  Object[size()-1];
		System.arraycopy(arr, 0, narr, 0, index);
		System.arraycopy(arr, index + 1, narr, index, size() - index -1);
		indx--;./
		arr = narr;
	}
	
	
	
}
