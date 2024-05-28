// Check if the number is atomorphic number 

import java.util.Scanner; 

class Atomorphic{
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in); 
		System.out.print("Enter the number : ");
		int num = sc.nextInt(); 
		System.out.println((Am(25))?"Atomorphic Number":"Not Atomorphic");

	}

	public static boolean Am(int num){
		int square = num * num ; 
		while(num>0){
			if(num%10 != square%10){
				return false; 
			}
			 num = num/10; 
			 square = square/10 ; 
		}
		return true; 
	}


}