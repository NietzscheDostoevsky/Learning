import java.util.Scanner;
class PrimeNumber{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number to find prime: ");
        int input = sc.nextInt();
        int n = input ;
        boolean isPrime = true ; 

        for(int i = 2; i<=n/2; i++){
        	if(n%i==0){
        		isPrime = false;
        		break ;  
        		
        	}else{
        		isPrime = true; 
        	}

        }
        if (isPrime) {
            System.out.println(n + " is a prime number.");
        } else {
            System.out.println(n + " is not a prime number.");
        }


	}
}