package arrayList;

import java.util.ArrayList;

public class ForEachDemo {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		
		list.forEach((ele) -> System.out.println(ele));
		for (Integer i: list) 
			System.out.println(i);
		
		list.forEach(null);
	}
}
