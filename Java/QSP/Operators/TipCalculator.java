import java.util.Scanner;

public class TipCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the subtotal : ");
        double subtotal = sc.nextDouble();
        System.out.print("Enter the tip rate : ");
        double tipRate = sc.nextDouble();

        double tip = subtotal * tipRate / 100;
        double total = subtotal + tip;

        System.out.println("The tip is " + tip + " and the total is " + total);
    }

}
