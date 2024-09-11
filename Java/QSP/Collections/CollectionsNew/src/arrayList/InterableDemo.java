package arrayList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class InterableDemo {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
//		ArrayList<Integer> list = new ArrayList<>(); 
//		for (int i = 1; i <=20; i++)
//			list.add(i);
//		
//		Iterator<Integer> iterator = list.iterator();
//		while(iterator.hasNext()) {
//			Integer element = iterator.next(); 
//			if(element %2 == 0)
//				System.out.println(element);
//		}
		
		ArrayList list = new ArrayList(); 
		list.add("One");
		list.add("Two");
		list.add(3);
		list.add(true);
		list.add(1.2);
		list.add("Thirty");
		
		ArrayList<String> list2 = new ArrayList<String>(list); 
		System.out.println(list2);
		try {
			for (String s : list2) {
				System.out.println(s.getClass());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		
//		ArrayList<String> stringList2 = list;
//		Iterator iterator = list.iterator();
//		while(iterator.hasNext()) {
//			Object obj = iterator.next();
//			if(!(obj instanceof String))
//				iterator.remove();
//		}
//		System.out.println(list);
//		ArrayList<String> stringList = list;
	}
}
