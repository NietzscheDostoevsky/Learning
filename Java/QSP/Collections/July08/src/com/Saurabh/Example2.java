package com.Saurabh;

import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class Example2 {
	
	public static void main(String[] args) {
		
	
		// TODO Auto-generated method stub
		
		List<E> list = (List<E>) Arrays.asList(10,20,30,40,50,60) ;
		System.out.println(list.contains(40));
		System.out.println(list.contains(70));
		System.out.println(list.contains("70"));
		
		TreeSet<Integer> set = new TreeSet<>(list) ;
		System.out.println(set.contains("70"));
		System.out.println(set.contains(null));
		
	}

}
