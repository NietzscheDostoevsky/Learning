public class Buffer {
    public static void main(String[] args) {
        int n = 5; // The number of rows for the triangle

        for (int i = 0; i < n; i++) {
            // Print leading spaces
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }
            // Print stars
            for (int k = 0; k <= i; k++) {
                System.out.print("*");
            }
            // Move to the next line
            System.out.println();
        }
    }
}
