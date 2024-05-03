import java.util.Scanner;

public class AreaHexagon {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the side of hexagon : ");
        double side = sc.nextDouble();

        // Calcultions
        double area = (3 * Math.sqrt(3) * side * side) / 2;
        System.out.println("The area of the Hexagon is: " + area);
    }

}
