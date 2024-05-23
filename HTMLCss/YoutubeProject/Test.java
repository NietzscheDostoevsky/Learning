import java.util.Scanner;

class Test {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        int input = sc.nextInt();
        sc.close();

        int n = input;
        // int n = 8;
        // int num = 1; // to print the numbers

        // // outer loop for rows ;

        // for (int i = 0; i < n; i++) {

        // // inner loop for columns
        // int p = num; // to print the numbers while decreaing it
        // for (int j = 0; j <= i; j++) {
        // System.out.print(p + " ");
        // p--;// to print decreing number as pointer moves across the row
        // num++; // calculate the number to print the next row.
        // }
        // System.out.println(); // move the cursor to the next row
        // num++; // add 1 more since next row is gonna have one mroe column.
        // }

        int reverse = 0;
        for (int i = n; i != 0; i = i / 10) {
            reverse = i % 10 + reverse * 10;
        }
        System.out.println("Reverse num is :" + reverse);
    }
}