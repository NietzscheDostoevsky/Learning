package com.Saurabh;

import java.util.Arrays;
import java.util.List;

public class AsList {
	public static void main(String[] args) {
		
		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8);
		System.out.println(list);
		Integer[] arr = new Integer[list.size()];
		for(int i = 0; i < list.size(); i++)
			arr[i] = list.get(i);
		System.out.println(Arrays.toString(arr));
		// created an array from the list
	}

}
