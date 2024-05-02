import java.util.Scanner;

public class BMI {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the weight in pounds: ");
        double weight = sc.nextDouble();
        weight = weight * 0.45359237; // kilograms
        System.out.print("Enter the height in inches: ");
        double height = sc.nextDouble();
        height = height * 0.0254; // meters

        // Calculations
        double BMI = (weight) / (height * height);
        System.out.println("BMI is " + BMI);

    }

}
