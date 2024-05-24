public class ABCD {
    public static void main(String[] args) {
        int n = 4;
        abcdSquare(n);
    }

    public static void abcdSquare(int n) {
        char alpha = 'a';
        int num = 8;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i % 2 == 0) {// even rows
                    System.out.print(alpha);
                    alpha++;
                } else { // odd rows
                    System.out.print(num);
                    num--;
                }
            }
            System.out.println();
            
        }
    }
}
