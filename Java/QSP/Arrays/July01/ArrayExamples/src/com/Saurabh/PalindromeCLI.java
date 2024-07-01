package com.Saurabh;

public class PalindromeCLI {
	
	public static void main(String[] args) {
		
		int num = Integer.parseInt(args[0]);
		if (isPalindrome(num)) {
			System.out.println(num + " The num is a Palindrome");
		} else {
			System.out.println("NOt a palindrome");
		}
	}
	
	private static boolean isPalindrome(int num) {
		
		int rev = 0; 
		int dup = num;
		while(num != 0) {
			int rem = num % 10;
			rev = rev * 10 + rem ;
			num  /= 10 ;
		}
		
		if( rev == dup) {
			return true;
		}
		return false;
	}

}
