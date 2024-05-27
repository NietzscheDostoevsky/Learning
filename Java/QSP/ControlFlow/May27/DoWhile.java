import java.util.Scanner; 
class DoWhile{
	public static void main(String[] args) {
		

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number : ");
		int input = sc.nextInt(); 
		//int num = input; 
		int num = 4321 ; 
		int reverse = 0 ; 


		do{
			num = num / 10; 
			count++;

		}while(num>0);
		System.out.println(count);
	}
}