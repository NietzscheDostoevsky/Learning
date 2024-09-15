package iterator;

import java.util.ArrayList;
import java.util.Spliterator;

public class SplititeratorDemo {
	public static void main(String[] args) {
		
		ArrayList<Double>  vals = new ArrayList<Double>();
		vals.add(1.0);
		vals.add(2.0);
		vals.add(3.0);
		vals.add(4.0);
		vals.add(5.0);
		
		//using tryAdvance() to display contents of vals. 
		System.out.print("Contents of vals: \n");
		Spliterator<Double> splititr = vals.spliterator();
		while (splititr.tryAdvance(n -> System.out.println(n))) ;
		while (splititr.tryAdvance(System.out::println));
		System.out.println();
		
		// create new list that contains square roots. 
		splititr = vals.spliterator();
		ArrayList<Double> sqrs = new ArrayList<Double>();
		while(splititr.tryAdvance(x -> sqrs.add(Math.sqrt(x))));
		
		//using  forEach to view the contents of sqrs. 
		sqrs.forEach(System.out::println);
	}
}
