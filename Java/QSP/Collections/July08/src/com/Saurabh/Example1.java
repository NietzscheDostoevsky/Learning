package com.Saurabh;

import java.util.*;

public class Example1 {
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4} ;
		System.out.println(Arrays.toString(arr));
		
		List list = new ArrayList();
		
		for( Integer i : arr) 
			list.add(i);
		
		System.out.println(list);
		int[] arr3 = new int[arr.length];
		
		for(Object i : arr) {
			System.out.println(i + " " + i instanceof Object);
		}
		
		for(Object i : arr) {
			System.out.println(i instanceof Integer);
		}
		
		int indx = 0;
		for(Object i : arr  ) {
			Integer j = (Integer)i;
			arr3[indx++] = j.intValue();
		}
		
		System.out.println(Arrays.toString(arr3));
		
		
		
	}

}
