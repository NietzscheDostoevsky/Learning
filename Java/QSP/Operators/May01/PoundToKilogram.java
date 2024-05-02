import java.util.Scanner;

public class PoundToKilogram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final double convert = 0.454;
        System.out.print("Enter a number in pounds : ");
        double pound = sc.nextDouble();
        double kilo = convert * pound;
        System.out.println(pound + " pounds is " + kilo + " kilograms ");
    }

}
