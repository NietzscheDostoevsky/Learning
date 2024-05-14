import java.util.Scanner ; 
class EliginilityCheck{
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in) ;
		System.out.print("Enter your percentage: ") ; 
		double percentage = sc.nextDouble(); 

		if (percentage > 60 ) 
			System.out.println("Eligible") ;
		if (!(percentage > 60 )) 
			System.out.println("Not Eligible") ; 

	}
}