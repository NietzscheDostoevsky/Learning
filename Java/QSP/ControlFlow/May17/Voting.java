import java.util.Scanner;

class Voting {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in) ; 
		System.out.println("Enter 1 for BJP "); 
		System.out.println("Enter 2 for Congress "); 
		System.out.println("Enter 3 for AAP "); 
		System.out.println("Enter 4 for  MNS"); 
		System.out.println("Enter 5 for NOTA "); 
		int num = sc.nextInt(); 

		switch (num) {

			case 1: {
				System.out.println("You voted for BJP") ;
				break; 
			}

			case 2: {
				System.out.println("You voted for Congress") ;
				break; 
			}

			case 3: {
				System.out.println("You voted for AAP") ;
				break; 
			}

			case 4: {
				System.out.println("You voted for MNS") ;
				break; 
			}
			case 5: {
				System.out.println("You voted for NOTA") ;
				break; 
			}
		default: {
				System.out.println("INVALID INPUT");
		}
		}

	}
}