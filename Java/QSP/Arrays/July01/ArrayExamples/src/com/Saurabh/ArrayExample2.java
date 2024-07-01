package com.Saurabh;

import java.util.Arrays;

public class ArrayExample2 {

		public static void main(String[] args) {
			 int [] arr = new int[30];
			 
			 int indx = 0;
			 for(int i = 10; i<=300; i+=10) {
				 arr[indx++] = i;
			 }
			 
			 System.out.println(Arrays.toString(arr));
		}
}
