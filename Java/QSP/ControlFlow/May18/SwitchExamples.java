import java.util.Scanner ; 

class SwitchExample{
	public static void main(String[] args) {
		
		int a = -97; 
		switch(a) {

		case 1 : System.out.println("CASE 1 " + a);// a++; 
		case 3 : System.out.println("CASE 3 " + a); a++ ; 
		case 7 : System.out.println("CASE 7 " + a); a++ ;//break ; 
		case 2 : System.out.println("CASE 2 " + a); //break ; 
		case 66 : System.out.println("CASE 66 "); break ;
		case -'b' : System.out.println("CASE a "); break ;
		case 89 : System.out.println("CASE 1 ");   break ;  
		default: System.out.println("ddefssult1 "); 	
		}
	}
}