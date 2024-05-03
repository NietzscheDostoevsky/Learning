import java.util.Scanner;

public class Interest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Balance: ");
        double balance = sc.nextDouble();
        System.out.print("Enter interest rate: ");
        double interestRate = sc.nextDouble();

        // Calculations
        double interest = balance * (interestRate / 1200);
        System.out.println("The interest is " + interest);
    }

}
