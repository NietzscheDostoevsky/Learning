import java.util.Scanner ; 

class Factorial{
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in) ; 
		System.out.print("Enter the number to factorial: ");
		double num = sc.nextInt() ; 
		
		double product = 1; 

		for(int i = 1 ; i<=num; i++){
			product = product * i ;
		}

		System.out.println(num + "! = " + product) ; 
		
		
	}
}
