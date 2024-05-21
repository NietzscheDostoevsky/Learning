import java.util.Scanner ; 

class PatternRightSideTriangle{
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in) ; 
		System.out.print("Enter the number to stars: ");
		int num = sc.nextInt() ; 
		
		// outer loop 
		for(int i = 1 ; i<=num ; i++){
			
			//loop for spaces
			for(int j = 1 ; j<=(num-i); j++){
				System.out.print(" ");
			}

			//loop to print star/triangle
			for(int j=1; j<=i; j++){
				System.out.print("* ");
			}
			System.out.println();
		}
		
	}
}
