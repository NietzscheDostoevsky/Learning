import java.util.Scanner ; 

class VovelOrConsonant {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in) ; 
		System.out.print("Enter a Character : ") ; 

		char ch = sc.next().toLowerCase().charAt(0) ; 

		if (ch=='a' || ch=='e' || ch=='e' || ch=='o' || ch=='u') {
			System.out.println(ch + " is a vovel"); 
		} else {
			System.out.println(ch + " is a consonany"); 
		}
	}
}