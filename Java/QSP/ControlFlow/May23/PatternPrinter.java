import java.util.Scanner;

public class PatternPrinter {

    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        // System.out.print("Enter the number to rows: ");
        // int input = sc.nextInt();
        // int n = input ;
        int n = 7;

        // printSquarePattern(num);
        pyramidPattern(n);
        System.out.println();
        System.out.println();

    }

    public static void pyramidPattern(int n) {

        // printing the pyramid pattern

        // outer loop to print the rows
        for (int i = 0; i < n; i++) {

            // inner loop to print the columns

            // first loop to print the leading blanks
            for (int j = 0; (i + j) < (n); j++) {
                System.out.print(" ");
            }
            // Second loop to print the stars

            for (int k = 1; k <= (i * 2 + 1); k++) {
                System.out.print("*");

            }

            System.out.println(); // poi9nting the cursonr t next line
        }

    }

}
