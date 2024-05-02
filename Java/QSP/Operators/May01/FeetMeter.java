import java.util.Scanner;

class FeetMeter {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        final double convert = 0.305; // foot
        System.out.print("Enter the value in feet : ");
        double feet = sc.nextDouble();
        double meter = convert * feet;
        System.out.print(feet + " feet is " + meter + " meter ");
    }

}
