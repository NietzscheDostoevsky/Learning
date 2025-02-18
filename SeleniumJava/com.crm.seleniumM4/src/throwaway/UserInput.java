package throwaway;

import java.util.Scanner;
public class UserInput {
	public static void main(String[] args) {
		System.out.println("Enter an integer: ");
		int num = 0;
		Scanner scanner = new Scanner(System.in); 
		num = scanner.nextInt();
		System.out.println("Double is : " + num * 2);
		System.out.println("Triple is : " + num * 3);
		
	}
}

