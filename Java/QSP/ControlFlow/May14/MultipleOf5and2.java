import java.util.Scanner; 
class MultipleOf5and2{
	public static void main(String[] args) {

		int num ; 
		Scanner sc = new Scanner(System.in) ; 
		System.out.print("Enter a number: ");
		num = sc.nextInt() ; 

		if (num%5 == 0 )
			System.out.print("HiFive"); 
		if (num%2 == 0 ) 
			System.out.print("HiEven");
	}
}