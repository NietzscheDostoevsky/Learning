package com.ListInterface;
import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {
		
		ArrayList arr = new ArrayList(); 
		arr.add("Kanchana"); 
		arr.add(420); 
		arr.add('c');
		arr.add(4.5d) ;
		arr.add(1.5f);
		arr.add(true);
		
		for(int i = 0; i < arr.size(); i++) {
			System.out.println(arr.get(i));
		}
		System.out.println(arr.indexOf(true));
		ArrayList arr2 = new ArrayList(); 
		
		arr.add("Kanchana"); 
		arr.add(420); 
		arr.add('c');
		arr.add(4.5d) ;
		arr.add(1.5f);
		arr.add(true);
		
		for(int i = 0; i < arr.size(); i++) {
			System.out.println(arr.get(i));
		}
		System.out.println(arr.indexOf(true));
		
		
		
		
		

	}

}
