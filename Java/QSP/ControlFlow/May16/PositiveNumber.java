import java.util.Scanner ; 
class PositiveNumber{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in) ; 
		System.out.print("Enter a num to check"); 
		int num = sc.nextInt(); 

		if (num ==0) {
			System.out.print("Number is neutral"); 
		} else {
			if(num>0) System.out.println("positive");
			else System.out.println("Negative");
		}
		
	}	
}
