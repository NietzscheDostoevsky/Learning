import java.util.Scanner;
class PrimeCheck{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number: ");
		int num = sc.nextInt(); 
		boolean prime = IsPrime(num);
		if(prime){
			System.out.println(num + " is prime");
		}else{
			System.out.println(num + " is not prime");
		}
		
	}

	public static boolean IsPrime(int num) {

		if(num <= 1)
			return false ; 
		if(num == 2)
			return true ;
		if(num % 2 == 0)
			return false ;

		for(int i = 3; i*i<=num; i = i+2){
			if(num%i == 0)
				return false;

		} 

		return true; 

	}
	
}