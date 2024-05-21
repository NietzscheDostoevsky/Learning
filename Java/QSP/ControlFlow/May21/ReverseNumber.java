import java.util.Scanner ; 

class ReverseNumber{
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in) ; 
		System.out.print("Enter the number to reverse: ");
		int num = sc.nextInt() ; 
		int rev = 0 ; 
		
		for(int i = num ; i!=0 ; i = i/10){
			rev = rev*10 + (i%10) ;

		}
		System.out.println(num + " Number's reverse value is  " + rev);

	}
}
