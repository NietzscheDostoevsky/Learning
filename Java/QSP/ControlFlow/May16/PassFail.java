import java.util.Scanner;

class PassFail {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("Enter your percentage: ");

		double percentage = sc.nextDouble();

		if (percentage <= 0 || percentage > 100) {
			System.out.println("You are fail");

		} else if (percentage <= 35) {
			System.out.println("You are fail");
		} else if (percentage <= 50) {

			System.out.println("You have C Grade");
		} else if (percentage <= 60) {
			System.out.println("YOu have Grade B");

		} else if (percentage <= 75) {
			System.out.println("YOu have A grade");
		} else {
			System.out.println("YOu have A++");
		}

	}
}