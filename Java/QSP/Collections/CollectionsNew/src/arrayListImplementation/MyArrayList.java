package arrayListImplementation;

import java.util.Arrays;

public class MyArrayList<E>  {
	
	E[] arr ;
	int indx = 0;
	@SuppressWarnings("unchecked")
	public MyArrayList() {
		arr = (E[]) new Object[10]; 
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
		for (int i = 0; i < indx; i++) {
			if (arr[i].equals(e))
				return i;
		}
		return -1;
	}
	
	public int size() {
		return indx;
	}
	
	public Integer get(int index) {
		if (index<0 || index>= size()) 
			throw new IndexOutOfBoundsException("Wrong Index Entered");
		return (Integer) arr[index];
	}
	
	
}
