package arrayList;

import java.util.Enumeration;
import java.util.Vector;

//A simple enum example where enum is declared
//outside any class (Note enum keyword instead of
//class keyword)
enum Color {
 RED,
 GREEN,
 BLUE;
}

public class DemoEnumeration {
	public static void main(String[] args) {
		Vector<Integer> obj = new Vector<>(); 
		for (int i = 0; i <=100; i+=10)
			obj.addElement(i);
		
		Enumeration<Integer> enumera = obj.elements(); 
		
		while(enumera.hasMoreElements()) {
			Integer i = enumera.nextElement();
			System.out.print(i + " ");
		}
		System.out.println();
		for (int i = 0; i <=100; i+=10)
			obj.addElement(i);
		
		while(enumera.hasMoreElements()) {
			Integer i = enumera.nextElement();
			enumera.nextElement();
			System.out.print(i + " ");
		}
	}
}
