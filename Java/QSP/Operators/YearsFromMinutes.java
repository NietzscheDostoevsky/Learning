import java.util.Scanner;

public class YearsFromMinutes {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        final int year = 365;
        System.out.print("Enter the number of minutes : ");
        long minutes = sc.nextLong();

        // Calculations
        long totalDays = minutes / (24 * 60);
        long totalYears = totalDays / year;
        long remainingDays = totalDays % year;

        System.out.println(
                minutes + " minutes " + "is approximately " + totalYears + " years and " + remainingDays + " days ");
    }
}
