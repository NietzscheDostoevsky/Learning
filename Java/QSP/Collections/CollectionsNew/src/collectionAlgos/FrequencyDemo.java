package collectionAlgos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;

public class FrequencyDemo {
	public static void main(String[] args) {
		ArrayList list = new ArrayList(); 
		for (int i = 1; i <=1000000; i++) 
			list.add((int) (Math.random()*10));
		
		//System.out.println(list);
		Set<Integer> set = new HashSet(list); 
		for (Integer i: set) {
			int count = Collections.frequency(list,  i);
			System.out.println(i + " : " + count);
		}
		
		Hashtable<Integer, Integer> hash = new Hashtable<>();
		
	}

}
