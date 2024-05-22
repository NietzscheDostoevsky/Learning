import java.util.Scanner;

class PatternRightSideTriangle {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number to stars: ");
		int num = sc.nextInt();

		// outer loop for rows
		for (int row = num; row >= 1; row--) {

			// inner loop for blank space col
			for (int col = 1; col <= (row - 1); col++) {
				System.out.print(" ");
			}
			// inner loop for printing the star
			for (int col = row; col != (num + 1); col++) {
				System.out.print("*");
			}
			System.out.println();
		}

	}
}
