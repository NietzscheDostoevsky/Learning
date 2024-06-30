package com.arrays;

import java.util.Arrays;

public class ArraySorting {

	public static void main(String[] args) {

		int[] a = { 5, 4, 3, 5, 2, 4, 5, 6, 7

		};
		System.out.println(Arrays.toString(a));
		bubbleSort(a);
		Arrays.sort(null, Collections);
		System.out.println(Arrays.toString(a));

	}

	private static void bubbleSort(int[] a) {
		// TODO Auto-generated method stub

		for (int i = 0; i < a.length; i++) {
			for (int j = i; j < a.length; j++) {
				if (a[i] > a[j]) {
					int temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				
				}
			}
		}
	}
	
	private static void 

}
