//package com.arrays;

import java.util.Arrays;

public class ArraySorting {

	public static void main(String[] args) {

		int[] a = { 5, 4, 3, 5, 2, 4, 5, 6, 7

		};
		System.out.println(Arrays.toString(a));
		bubbleSort(a);
		System.out.println(Arrays.toString(a));
		int b[] = {8,5,4,3,5,7,4,3,5};
		selectionSort(b);
		System.out.println(Arrays.toString(b));

		int [] c = {
			4,3,234,65,6,34,2,6,5487,5366,3426, 234,64,45,436
		};
		insertionSort(c);
		System.out.println(Arrays.toString(c));
	}

	private static void bubbleSort(int[] a) {
		// Bubble Sort

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
	
	private static void selectionSort(int[] a) {
		// Selection Sort

		for(int i = 0; i < a.length ; i++) {
			int min = i;

			for(int j = i; j < a.length ; j++){

				if(a[min] > a[j]) {
					min = j;
				}
			}

			int temp = a[min];
			a[min] = a[i];
			a[i] = temp;
		}
	}

	private static void insertionSort(int[] a) {
		// insertion sort

		for(int i = 0; i < a.length; i++){
				int temp = a[i];
				int j = i -1;
				while ( j >= 0 && a[j] > temp) {
					a[j + 1] = a[j];
					j--;
				}
				a[j + 1 ] = temp;

		}

	}

}
