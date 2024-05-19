import java.util.Scanner ; 

class Seasons{

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in) ; 
		System.out.print("Enter a month : "); 
		String month = sc.next().toUpperCase() ;

		switch(month) {

			case "FEB" :
			case "MAR" :
			case "APR" :{
				System.out.println(month + "Its summer") ;
				break;
			}
			case "JUN" :
			case "JUL" :
			case "AUG" :
			case "SEP" :{
				System.out.println(month + "Its Rainy") ;
				break;
			}
			case "OCT" :
			case "NOV" :
			case "DEC" :
			case "JAN" :{
				System.out.println(month + "Its Winter") ;
				
			}
			default:{
				System.out.println("Wrong input") ;
			}

		}

	}
}