public class ABCD {
    public static void main(String[] args) {
        int n = 4; // Example size for a 4x4 pattern
        abcdSquare(n);
    }

    public static void abcdSquare(int n) {
        char alpha = 'a';
        int num = 8;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i % 2 == 0) { // Even rows (0, 2, 4, ...) for letters
                    System.out.print(alpha);
                    alpha++;
                } else { // Odd rows (1, 3, 5, ...) for numbers
                    System.out.print(num);
                    num--;
                }
            }
            System.out.println();
            if (i % 2 == 0) { // Reset num after letter rows
                num = num - n + 1;
            }
        }
    }
}
