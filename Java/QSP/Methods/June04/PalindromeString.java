import java.util.Scanner; 

class PalindromeString{
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in); 
		System.out.print("Enter a string: "); 
		String name = sc.nextLine(); 
		boolean isPal = isPalindrome(name);
		System.out.println(isPal?"Palindrome":"Not a Palindrome");

	}

	public static boolean isPalindrome(String name){
		String rev = ""; 
		for(int i = 0; i<name.length(); i++){
			rev = name.charAt(i) + rev ; 
		}
		if(rev.equals(name)){
			return true ; 
		}else{
			return false ;
		}
	}
	
}