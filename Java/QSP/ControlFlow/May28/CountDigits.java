import java.util.Scanner; 
class CountDigits{
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in); 
		System.out.print("Enter the number : ");
		int num = sc.nextInt();

		int count = 0 ; 
		for(int i = num; num != 0 ; num = num / 10){
			count++; 
		}
		System.out.println(count);
	}
}