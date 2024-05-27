import java.util.Scanner; 
class DoWhile{
	public static void main(String[] args) {
		

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number : ");
		int input = sc.nextInt(); 
		int num = input; 
		//int num = 4321 ; 
		int count = 0 ; 

		for (int i = num; i>0; i=i/10){
			count++;

		}
		System.out.println(count);
	}
}