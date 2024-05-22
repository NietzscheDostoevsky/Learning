import java.util.Scanner;

public class ReverseNumber {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number ");
        int num = sc.nextInt();
        sc.close();

        int rev = 0;
        for (int i = num; i != 0; i = i / 10) {

            rev = i % 10 + rev * 10;
        }

        System.out.println("REverse num = " + rev);

    }
}
