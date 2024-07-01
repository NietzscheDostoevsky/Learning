package com.Saurabh;

import java.util.Arrays;

public class ArrayExample4 {
	
	public static void main(String[] args) {
		 
		System.out.println((int)Math.random() * 10);
		int [] arr = new int[10];
		for (int i = 0; i < 10; i++) {
			arr[i] = (int) (Math.random()* 10);
		}
		System.out.println(Arrays.toString(arr));
	}
}
