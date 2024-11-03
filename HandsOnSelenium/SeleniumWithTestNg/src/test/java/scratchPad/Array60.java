package scratchPad;

import java.util.HashMap;

/*
 * 60. Find Missing and Repeating Numbers from an array.
* Given an unsorted array arr of size n of positive integers. One
* number 'A' from set {1, 2,....,N} is missing and one number 'B'
* occurs twice in array. Find these two numbers.
* Input: n=3, arr[]={1,3,3}
* Output: 3 2
* Explanation: Repeating number is 3 and smallest positive missing
* number is 2.
 */

public class Array60 {
	public static void main(String[] args) {
        int[] arr = {1, 2,3,4,4,5,6,7};
        int n = 8;
        findMissingAndRepeating(arr, n);
        findMissingAndRepeating2(arr, n);
    }
	
	 private static void findMissingAndRepeating2(int[] arr, int n) {
		 HashMap<Integer, Integer> frequency = new HashMap<>(); 
		 for (int num : arr)
			 frequency.put(num, frequency.getOrDefault(num, 0) + 1);
		 int repeating = -1;
		 int missing = -1;
		 
		 for (int i = 1; i <= n; i++) {
			 int count = frequency.getOrDefault(i, 0);
			 if (count == 2)
				 repeating = i; 
			 else if(count == 0)
				 missing = i;
		 }
		 System.out.println("Repeating: " + repeating);
		 System.out.println("Missing: " + missing);
		 
	}

	public static void findMissingAndRepeating(int[] arr, int n) {
	        // Calculate the expected sum and sum of squares
	        int expectedSum = n * (n + 1) / 2;
	        int expectedSumSq = n * (n + 1) * (2 * n + 1) / 6;

	        // Initialize the actual sum and sum of squares
	        int actualSum = 0, actualSumSq = 0;

	        // Calculate actual sum and sum of squares from the array
	        for (int num : arr) {
	            actualSum += num;
	            actualSumSq += num * num;
	        }

	        // Difference between the expected and actual sums
	        int sumDiff = actualSum - expectedSum;  // A - B
	        int sqSumDiff = actualSumSq - expectedSumSq;  // A^2 - B^2

	        // A + B = sqSumDiff / sumDiff
	        int sumAplusB = sqSumDiff / sumDiff;

	        // Solving the equations to get A and B
	        int A = (sumAplusB + sumDiff) / 2;
	        int B = A - sumDiff;

	        // Output the results
	        System.out.println("Repeating number: " + A);
	        System.out.println("Missing number: " + B);
	    }
}
