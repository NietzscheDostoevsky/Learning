class ArrayPrint3D {
    public static void main(String[] args) {

        int[][][] a = {
                { { 1, 2, 3 },
                        { 4, 5, 6 },
                        { 7, 8, 9 } },
                { { 10, 11, 12 },
                        { 13, 14, 15 },
                        { 16, 17, 18 } },
                { { 19, 20, 21 },
                        { 22, 23, 24 },
                        { 25, 26, 27 } }
        };

        // for loop
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                for (int k = 0; k < a[i][j].length; k++) {
                    System.out.print(a[i][j][k] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
        System.out.println("----------------------");
        int i = 0;
        while (i < a.length) {
            int j = 0;
            while (j < a[i].length) {
                int k = 0;
                while (k < a[i][j].length) {
                    System.out.print(a[i][j][k] + " ");
                    k++;
                }
                System.out.println();
                j++;
            }
            System.out.println();
            i++;
        }

        System.out.println("----------*------------");

        i = 0;
        do {
            int j = 0;
            do {
                int k = 0;
                do {
                    System.out.print(a[i][j][k] + " ");
                    k++;
                } while (k < a[i][j].length);
                System.out.println();
                j++;
            } while (j < a[i].length);
            System.out.println();
            i++;
        } while (i < a.length);

        System.out.println("--------**--------------");

        // for each

        for (int[][] d3 : a) {
            for (int[] d2 : d3) {
                for (int d1 : d2) {
                    System.out.print(d1 + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
        System.out.println("--------***--------------" + "\n");

        System.out.println(java.util.Arrays.deepToString(a));
    }

}