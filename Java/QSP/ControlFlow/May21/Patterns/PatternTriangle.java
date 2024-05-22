import java.util.Scanner;

class PatternTriangle {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number to stars: ");
		int num = sc.nextInt();

		for (int row = 1; row <= num; row++) {

			for (int col = 1; col <= row; col++) {
				System.out.print("* ");
			}
			System.out.println();
		}

	}
}
