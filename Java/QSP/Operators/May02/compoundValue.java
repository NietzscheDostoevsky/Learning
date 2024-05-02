import java.util.Scanner;

public class compoundValue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the monthly saving amount : ");
        double principal = sc.nextDouble();

        // Calculations
        double interestRate = 0.05 / 12;
        int t = 6;
        double amount = principal * Math.pow((1 + interestRate), t);

        System.out.println("After six months, the account value is Rs " + amount);

    }

}
