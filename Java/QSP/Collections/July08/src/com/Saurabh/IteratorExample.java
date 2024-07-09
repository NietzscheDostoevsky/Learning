package com.Saurabh;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorExample {
	
	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<>();
		for(int i = 10; i<=100; i+=10) {
			list.add(i);
		}
		
		Iterator<Integer> abc = list.iterator();
		while(abc.hasNext()) {
			System.out.println(abc.next());
		}
	}

}
