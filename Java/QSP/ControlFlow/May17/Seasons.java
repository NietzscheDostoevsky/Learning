import java.util.Scanner ; 

class Seasons{

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in) ; 
		System.out.print("Enter a month : "); 
		String month = sc.next().toUpperCase() ;

		switch(month) {

			case "FEB" :{
				System.out.println(month + "Its summer") ;
				break;
			}
			case "MAR" :{
				System.out.println(month + "Its summer") ;
				break;
			}
			case "APR" :{
				System.out.println(month + "Its summer") ;
				break;
			}
			case "JUN" :{
				System.out.println(month + "Its Rainy") ;
				break;
			}
			case "JUL" :{
				System.out.println(month + "Its Rainy") ;
				break;
			}
			case "AUG" :{
				System.out.println(month + "Its Rainy") ;
				break;
			}
			case "SEP" :{
				System.out.println(month + "Its Rainy") ;
				break;
			}
			case "OCT" :{
				System.out.println(month + "Its Winter") ;
				break;
			}
			case "NOV" :{
				System.out.println(month + "Its Winter") ;
				break;
			}
			case "DEC" :{
				System.out.println(month + "Its Winter") ;
				break;
			}
			case "JAN" :{
				System.out.println(month + "Its Winter") ;
				break;

			}
			default:{
				System.out.println("Wrong input") ;
			}

		}

	}
}