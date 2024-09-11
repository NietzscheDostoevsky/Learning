package iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class IteratorDemo {

	public static void main(String[] args) {
		
		ArrayList<String> list = new ArrayList<String>();
		list.add("C");
		list.add("A");
		list.add("E");
		list.add("B");
		list.add("D");
		list.add("F");
		
		Iterator<String> itr = list.iterator();
		
		// print original content of list. 
		System.out.print("Modified contents of list: ");
		while(itr.hasNext()) {
			String elementString = itr.next();
			System.out.print(elementString + " ");
		}
		System.out.println();
		
		//Modify each element of the list. 
		ListIterator<String> litr = list.listIterator();
		while(litr.hasNext()) {
			String elemtnString = litr.next();
			litr.set(elemtnString + "+");
		}
		System.out.println();
		
		//print modified content of the list. 
		System.out.print("Modified contents of list: ");
		itr = list.iterator();
		while(itr.hasNext()) {
			String elementString = itr.next();
			System.out.print(elementString + " ");
		}
		System.out.println();
		
		// displaying the list backwards. 
		System.out.print("Modified list backwards: ");
		while(litr.hasPrevious()) {
			String elemtnString = litr.previous();
			System.out.print(elemtnString + " ");
		}
		System.out.println();
	}

}
