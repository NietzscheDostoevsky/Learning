package com.ListInterface;

import java.util.*;

public class ListMethods {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();

		
		list.add("Apple");
		list.add("Banana");
		list.add("Cherry");

		
		List<String> moreFruits = new ArrayList<>();
		moreFruits.add("Date");
		moreFruits.add("Elderberry");
		list.addAll(moreFruits);

		
		list.remove("Banana");

		
		List<String> removeFruits = new ArrayList<>();
		removeFruits.add("Apple");
		removeFruits.add("Date");
		list.removeAll(removeFruits);

		
		int indexOfCherry = list.indexOf("Cherry");

		
		list.add("Cherry");
		int lastIndexOfCherry = list.lastIndexOf("Cherry");

		
		String fruitAtIndex1 = list.get(1);

		list.set(1, "Fig");
		System.out.println(list);
		
		

	}
}
