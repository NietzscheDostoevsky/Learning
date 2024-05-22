import java.util.Scanner;

class PatternReverseTriangle {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number to stars: ");
		int num = sc.nextInt();

		for (int row = num; row >= 1; row--) {

			for (int col = 1; col <= row; col++) {
				System.out.print("* ");
			}
			System.out.println();
		}

	}
}
