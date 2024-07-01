package com.Saurabh;

import java.util.Arrays;

public class Array2DigitRandom {
	
	public static void main(String[] args) {
		
		int [] arr = new int[10];
		
		int count = 0;
		int a = 0;
		
		while(count != 10) {
			a++;
			int num = (int)(Math.random() * 100) ; 
			if( num < 100 && num > 10) {
				arr[count++] = num;
			}
		}
		
		System.out.println(Arrays.toString(arr));
		System.out.println(a);
		
	}

}
