/**
 * 
 */
package com.Saurabh;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 */
public class ArrayExample1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the size: ");

		int size = scanner.nextInt();

		int[] arr = new int[size];

		System.out.print(Arrays.toString(arr));

		for( int i = 0; i < arr.length; i++) {
			System.out.print("Enter element " + (i + 1 ) + " : ");
			arr[i] = scanner.nextInt();
		}
		System.out.println(Arrays.toString(arr));
	}

}
