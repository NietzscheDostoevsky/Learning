// Check if the number is Peterson number 

import java.util.Scanner; 

class Peterson{
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in); 
		System.out.print("Enter the number : ");
		int num = sc.nextInt(); 

		int originalNum = num ; 
		int result = 0; 

		// LOGIC 

		while(originalNum != 0){
			int lastDigit = originalNum%10; 
			int fact = 1; 
			for(int i = 1; i<= lastDigit; i++){
				fact = fact * i ; 
			}

			result = result + fact ; 
			originalNum = originalNum / 10 ; 
		}

		if(result == num){
			System.out.println("Peterson Number");
		}else{
			System.out.println("Not a peterson number");
		}


	}
}