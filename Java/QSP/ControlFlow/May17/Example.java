import java.util.Scanner;

class SwitchExample {
	public static void main(String[] args) {

		int num = 2 ; 
		switch (num) {

			case 1: {
				System.out.println("Case 1") ;
				break; 
			}

			case 2: {
				System.out.println("Case 2") ; 
				break;
			}

			case 3: {
				System.out.println("Case 3") ; 
				break;
			}

			default: {
				System.out.println("default block") ; 
			}
		}

	}
}