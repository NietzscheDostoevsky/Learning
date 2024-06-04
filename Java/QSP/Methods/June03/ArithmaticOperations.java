import java.util.Scanner; 
class ArithmaticOperations{

	public static void main(String[] args) {
		addition();
		substraction();
		multiplication();
		division();
		mod();

	}

	public static void addition(){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter num1: ");
		int num1 = sc.nextInt();
		System.out.print("Enter num2: ");
		int num2 = sc.nextInt(); 

		int out = num1 + num2 ; 
		System.out.println(num1 + " + " + num2 + " = " + out) ; 
			
	}

	public static void substraction(){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter num1: ");
		int num1 = sc.nextInt();
		System.out.print("Enter num2: ");
		int num2 = sc.nextInt(); 

		int out = num1 - num2 ; 
		System.out.println(num1 + " - " + num2 + " = " + out) ; 
			
	}

	public static void multiplication(){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter num1: ");
		int num1 = sc.nextInt();
		System.out.print("Enter num2: ");
		int num2 = sc.nextInt(); 

		int out = num1 * num2 ; 
		System.out.println(num1 + " X " + num2 + " = " + out) ; 
			
	}

	public static void division(){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter num1: ");
		int num1 = sc.nextInt();
		System.out.print("Enter num2: ");
		int num2 = sc.nextInt(); 

		int out = num1 / num2 ; 
		System.out.println(num1 + " / " + num2 + " = " + out) ; 
			
	}

	public static void mod(){
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter num1: ");
		int num1 = sc.nextInt();
		System.out.print("Enter num2: ");
		int num2 = sc.nextInt(); 

		int out = num1 % num2 ; 
		System.out.println(num1 + " % " + num2 + " = " + out) ; 
			
	}

}