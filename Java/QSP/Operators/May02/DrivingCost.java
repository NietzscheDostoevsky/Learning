import java.util.Scanner;

public class DrivingCost {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the driving distance: ");
        double distance = sc.nextDouble();
        System.out.print("Enter miles per gallon: ");
        double mpg = sc.nextDouble();
        System.out.print("Enter price per gallon: ");
        double rate = sc.nextDouble();

        // Calculations
        double amount = (distance / mpg) * rate;
        System.out.println("The cost of driving is: $" + amount);

    }
}
