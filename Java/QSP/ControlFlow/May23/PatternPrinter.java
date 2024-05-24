import java.util.Scanner;

public class PatternPrinter {

    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        // System.out.print("Enter the number to rows: ");
        // int input = sc.nextInt();
        // int n = input ;
        int n = 9;

        pyramidPattern(n);
        System.out.println();

        inversePyramid(n);
        System.out.println();

        rightArrowTriangle(n);

    }

    public static void pyramidPattern(int n) {

        // printing the pyramid pattern

        // outer loop to print the rows
        for (int i = 0; i < n; i++) {
            // inner loop to print the columns

            // first loop to print the leading blanks
            for (int j = 0; (i + j) < (n - 1); j++) {
                System.out.print(" ");
            }
            // Second loop to print the stars
            for (int k = 1; k <= (i * 2 + 1); k++) {
                System.out.print("*");
            }
            System.out.println(); // poi9nting the cursonr t next line
        }

    }

    public static void inversePyramid(int n) {
        // printing inverse pyramid
        int p = n;
        // outer loop to print the columns
        for (int i = 0; i < n; i++) {

            // first iner loop to print the spaces
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            // second loop to print stars
            for (int k = (2 * p - 1); k > 0; k--) {
                System.out.print("*");
            }
            p--;
            System.out.println();
        }
    }

    public static void rightArrowTriangle(int n) {
        
        // outer loop to print the columns 
        for(int i = 0; i<n; i++){

            for(int j = 0; )
        }

    }

}
