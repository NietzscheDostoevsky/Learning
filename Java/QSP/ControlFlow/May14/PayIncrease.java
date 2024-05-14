import java.util.Scanner; 
class PayIncrease{
	public static void main(String[] args) {

	Scanner sc = new Scanner(System.in) ; 
	double score ; 
	System.out.print("Enter Score : " ) ;
	score = sc.nextDouble(); 

	if (score > 90 ) 
		score = score * 1.03 ;
	System.out.println("New score " + score) ;
	}
}