package selectClass;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayListToArray {
	
	public static void main(String[] args) {
		// Create an array list.
		ArrayList<Integer> al = new ArrayList<Integer>();
		// Add elements to the array list.
		al.add(1);
		al.add(2);
		al.add(3);
		al.add(4);
		System.out.println("Contents of al: " + al);
		// Get the array.
		System.out.println(Arrays.toString(al.toArray()));
		
		
		}

}
