import java.util.Scanner ;

class Fibonacci{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in) ; 

		System.out.print("Enter the number of sequence: ");
		int num = sc.nextInt() ; 

		int firstTerm = 0 ; 
		int secondTerm = 1 ; 

		int terms = num ;

		//logic 

		for(int i = 1; i<=terms; i++){
			System.out.print(" " + firstTerm) ; 
			// inner logic 

			int nextTerm = firstTerm + secondTerm; 
			firstTerm = secondTerm ; 
			secondTerm = nextTerm ; 

		}

	}
}