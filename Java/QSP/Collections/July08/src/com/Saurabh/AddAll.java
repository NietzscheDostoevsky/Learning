package com.Saurabh;
import java.util.*;

public class AddAll {

	public static void main(String[] args) {
		
        // Step 1: Create a List with some duplicate elements
        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("banana");
        list.add("apple"); // Duplicate element
        list.add("orange");
        list.add("banana"); // Duplicate element
        list.add("grape");

        // Print the original list
        System.out.println("Original list: " + list);

        // Step 2: Convert the List to a Set
        Set<String> set = new HashSet<>(list);

        // Step 3: Print the Set to show that duplicates are not retained
        System.out.println("Set without duplicates: " + set);
        
        set.add("Monkey");
        System.out.println(set);
        List<String> list2 = new ArrayList<>();
        list2.add("Gorilla");
        list2.add("apple");
        System.out.println("List 2 :" + list2);
        System.out.println(set.addAll(list2));
        System.out.println(set);
	}

}


