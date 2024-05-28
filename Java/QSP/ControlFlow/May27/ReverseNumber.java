import java.util.Scanner;
class ReverseNumber{
	public static void main(String[] args) {
		

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a number to reverse: ");
		int input = sc.nextInt(); 
		int num = input;

		int reverse = 0 ; 
		for(int i =num ; i!=0; i=i/10 ){
			reverse = (i%10) + (reverse * 10);
		}
		System.out.println(reverse);
		System.out.println();
		System.out.println("-------------");

		num = input;
		reverse = 0  ; 
		while(num!=0){
			reverse = (num%10) + (reverse * 10) ; 
			num = num/10;
		}
		System.out.println(reverse);
		System.out.println();
		System.out.println("-------------");

		num = input ; 
		reverse = 0 ; 
		do{
			reverse = (num%10) + reverse * 10 ; 
			num = num/10 ; 
		}while(num!=0);
		System.out.println(reverse);
		System.out.println();
		System.out.println("-------------");


	}	

}