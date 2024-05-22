import java.util.Scanner;

public class PatternPractice {
    public static void main(String[] args) {

        // Scanner sc = Scanner(System.in);
        // System.out.print("Enter number of rows : ");
        // int input = sc.nextInt() ;
        // int n = input ;
        int n = 7;
        int num = 1;
        // loopo for the rows
        for (int i = 0; i < n; i++) {

            // looping for columns and printing the numbers
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
}
