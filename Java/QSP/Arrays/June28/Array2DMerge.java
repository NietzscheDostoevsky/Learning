public class Array2DMerge {

    public static void main(String[] args) {

        int[][] a1 = {
                { 10, 20 },
                { 30, 40, 50 }
        };

        int[][] a2 = {
                { 60, 70 }
        };

        System.out.println(java.util.Arrays.deepToString((merge2D(a1, a2))));

    }

    public static int[] merge2D(int[][] a1, int[][] a2) {
        // merges two different 2D arrays and returns a new 2D array

        int d1l1 = a1.length; // length of dimension 1, of array 1
        int d1l2 = a2.length;
        int d1c = d1l1 + d1l2; // dim 1 length of the return array
        int[][] c = new int[d1c][];

        for (int i = 0; i < d1c; i++) {
            c[i] = new int[a[i].length];
            for(int j = 0; j < a1l1; j++){
                c[i][j] = a1[i][j];
            }
        }

        return c;

    }
}
