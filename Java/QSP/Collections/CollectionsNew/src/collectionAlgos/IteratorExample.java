package collectionAlgos;

import java.util.ArrayList;
import java.util.Collections;

public class IteratorExample {
	public static void main(String[] args) {
		ArrayList<Double> list = new ArrayList<>();
		for (int i = 1; i <= 10; i++)
			list.add( Math.random()*10);
		System.out.println(list);
		
		Collections.sort(list, (e1,e2) -> (e2.compareTo(e1)));
		System.out.println(list);
	}
}
