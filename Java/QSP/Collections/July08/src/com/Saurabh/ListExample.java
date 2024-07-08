package com.Saurabh;

import java.util.ArrayList;
import java.util.Collection;

public class ListExample {

	public static void main(String[] args) {
		
		Collection<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(2);
		list.add(4);
		System.out.println(list);
		list.remove(4);
		list.remove(4);
		if(list.contains(4))
			list.remove(4);
		else
			System.out.println("element not found");
		System.out.println(list);
		

	}

}
