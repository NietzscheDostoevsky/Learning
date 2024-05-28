import java.util.Scanner;

class PatternQuestions{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number of rows: ");
		String input = sc.nextLine(); // Read input as string
        int num;
        
        if (input.isEmpty()) {
            num = 5; // Default value
        } else {
            num = Integer.parseInt(input); // Convert string to integer
        }
        sc.close();

		Pattern1(num);
		System.out.println("\n----------------------");
		Pattern2(num);
		System.out.println("\n----------------------");
		Pattern3(num);
		System.out.println("\n----------------------");
		Pattern4(num);
		System.out.println("\n----------------------");
		Pattern5(num);
		System.out.println("\n----------------------");
		Pattern6(num);
		System.out.println("\n----------------------");
		
	}

	public static void Pattern1(int num){
		/*
		1
		2 9
		3 8 10
		4 7 11 14
		5 6 12 13 15 */
	}

	public static void Pattern2(int num){
		/*
		*/
	}
	public static void Pattern3(int num){
		/*
		*/
	}
	public static void Pattern4(int num){
		/*
		*/
	}
	public static void Pattern5(int num){
		/*
		*/
	}
	public static void Pattern6(int num){
		/*
		*/
	}

}