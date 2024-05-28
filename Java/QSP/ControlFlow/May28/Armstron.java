// to check if the number is Armstrong number  

import java.util.Scanner; 

class Armstrong{
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in); 
		System.out.print("Enter the number : ");
		int num = sc.nextInt(); 
		
		int originalNumber = num ; 
		int result = 0 ;

		while(originalNumber != 0){
			int lastDigit = originalNumber%10 ; 
			result = result + (lastDigit*lastDigit*lastDigit); 
			originalNumber = originalNumber / 10 ;
		}

		if(num == result){
			System.out.println("Armstrong number");
		}else{
			System.out.println("Not Armstrong");
		}
	}
}