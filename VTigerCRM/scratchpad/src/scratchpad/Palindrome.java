package scratchpad;

public class Palindrome {
	public static void main(String[] args) {
		String nameString = "rajat";
		System.out.println(isPalindrome(nameString));
	}
	
	public static boolean isPalindrome(String name) {
		
		for (int i = 0, j = name.length() -1 ; i < j; i++, j--) {
			if (name.charAt(i) != name.charAt(j))
				return false;
		}
		return true;
	}
}
