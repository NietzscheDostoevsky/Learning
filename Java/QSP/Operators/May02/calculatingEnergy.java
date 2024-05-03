
import java.util.Scanner;

public class calculatingEnergy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the amount of water in kilograms : ");
        double m = sc.nextDouble();
        System.out.print("Enter the initial terperatue: ");
        double initialTemp = sc.nextDouble();
        System.out.print("Enter the final temperature: ");
        double finalTemp = sc.nextDouble();

        // Calculating energy
        double energy;
        energy = m * (finalTemp - initialTemp) * 4184;
        System.out.println("The energy needed is " + energy + " joules");
    }

}
