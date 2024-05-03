import java.util.Scanner;

public class runwayLength {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter speed and accelaration : ");
        double speed = sc.nextDouble();
        double accelaration = sc.nextDouble();

        // Calculation

        double length = (speed * speed) / (2 * accelaration);
        System.out.println("The min runway length for this airplane is " + length);

    }

}
