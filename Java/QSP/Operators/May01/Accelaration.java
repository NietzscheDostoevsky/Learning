import java.util.Scanner;

class Accelaration {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the v0 : ");
        double v0 = sc.nextDouble();
        System.out.print("Enter the v1 : ");
        double v1 = sc.nextDouble();
        System.out.print("Enter the time t : ");
        double time = sc.nextDouble();

        // Calculations

        double acc = (v1 - v0) / time;
        System.out.println("The average accelaration is : " + acc);

    }

}
