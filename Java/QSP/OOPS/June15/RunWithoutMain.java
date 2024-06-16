import java.util.Scanner ; 

class RunWithoutMain {
	static Scanner sc = new Scanner(System.in); 
	static {
		System.out.print("Enter a number: ");
	}
	static int num = sc.nextInt(); 

	static {
		if(num % 2 == 0){
			System.out.println(num + " is Even");
		}
		else {
			System.out.println(num + " is Odd");
		}
		System.exit(0);
	}
}