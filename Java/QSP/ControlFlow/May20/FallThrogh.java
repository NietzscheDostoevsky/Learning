import java.util.Scanner ; 

class FallThrough{
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in) ; 
		System.out.print("ENter a character: " ) ;
		char ch = sc.next().toLowerCase().charAt(0);

		switch(ch) {
		case 'a' : 
		case 'e' : 
		case 'i' :
		case 'o' : 
		case 'u' : System.out.println("VOWEL") ; break ; 
		default : System.out.println("Not a vowel"); 
		}
	}
}