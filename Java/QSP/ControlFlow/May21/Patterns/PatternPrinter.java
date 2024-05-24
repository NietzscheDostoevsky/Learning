import java.util.Scanner;

public class PatternPrinter {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number to stars: ");
        int num = sc.nextInt();

        printSquarePattern(num);
        System.out.println();
        
        printIncrementalPattern(7); // For the second pattern, you can pass 7 or any other number
        System.out.println();
        
        printReverseTrianglePattern(num);
    }

    public static void printSquarePattern(int num) {
        for (int row = 1; row <= num; row++) {
            for (int col = 1; col <= num; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    public static void printIncrementalPattern(int n) {
        int num = 1;
        for (int i = 0; i < n; i++) {
            int p = num;
            for (int j = 0; j <= i; j++) {
                System.out.print(p + " ");
                p--;
                num++; // to count what num to start from next row
            }
            num++; // since next row have to print one more col than previous
            System.out.println();// move the cursor to next line
        }
    }

    public static void printReverseTrianglePattern(int num) {
        for (int row = num; row >= 1; row--) {
            for (int col = 1; col <= row; col++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}

