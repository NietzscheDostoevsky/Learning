import java.util.Scanner;

class PatternUpperRightTriangle {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number to stars: ");
        int num = sc.nextInt();
        int n = num;

        for (int i = 0; i < n; i++) {

            // Printing leading spaces
            for (int j = 0; j < i; j++) {
                System.out.print("");
            }

            // Printing stars

            for (int k = i; k < n; k++) {
                System.out.print("*");
            }
            // Moving to next line
            System.out.println();
        }

    }

}
