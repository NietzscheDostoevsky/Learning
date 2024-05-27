import java.util.Scanner;
class ReverseNumber{
	public static void main(String[] args) {
		

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a number to reverse: ");
		int num = sc.nextInt(); 

		int reverse = 0 ; 
		for(int i =num ; i>=0; i=i/10 ){
			reverse = (i%10) + (reverse * 10);
		}
		System.out.println(reverse);
		System.out.println();
		System.out.println("-------------");
	}
}