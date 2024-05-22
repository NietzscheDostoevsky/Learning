public class NumberPattern {
    public static void main(String[] args) {
        int n = 5; // Number of rows
        int startNum = 1; // Starting number for the first row

        for (int i = 1; i <= n; i++) {
            // Calculate the starting number for the current row
            int rowStart = startNum + i - 1;

            // Print numbers in reverse order for the current row
            for (int j = rowStart; j >= startNum; j--) {
                System.out.print(j + " ");
            }

            // Update startNum for the next row
            startNum = rowStart + 1;

            // Move to the next line after printing the current row
            System.out.println();
        }
    }
}
