import java.util.Scanner;

class Assignment {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int x = 0; // delcaration
		System.out.print("Enter a number ");
		int y = sc.nextInt();

		if (y > 0) {
			x = 1;
		}
		System.out.println("x = " + x);

	}
}
