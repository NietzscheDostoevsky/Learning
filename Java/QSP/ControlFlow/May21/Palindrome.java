import java.util.Scanner ; 

class Palindrome{
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in) ; 
		System.out.print("Enter the number to reverse: ");
		int num = sc.nextInt() ; 
		int rev = 0 ; 
		int dup = num ; 
		
		for(int i = num ; i!=0 ; i = i/10){
			rev = rev*10 + (i%10) ;

		}
		System.out.println(num + " Number's reverse value is  " + rev);

		if(dup == rev){
			System.out.println(num + "Is a palindrome");
		} else {
			System.out.println(num + "Is not a palindrome");
		}

	}
}
