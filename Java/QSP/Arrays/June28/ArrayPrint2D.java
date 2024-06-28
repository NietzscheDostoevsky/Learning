class ArrayPrint2D {

    public static void main(String[] args) {
        int[][] a = { { 1, 2 },
                { 3, 4, 5 } };

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
        int i = 0;
        while (i < a.length) {
            int j = 0;
            while (j < a[i].length) {
                System.out.print(a[i][j] + " ");
                j++;
            }
            System.out.println();
            i++;
        }

        System.out.println();
        i = 0;
        do {
            int j = 0;
            do {
                System.out.print(a[i][j] + " ");
                j++;
            } while (j < a[i].length);
            System.out.println();
            i++;
        } while (i < a.length);
        System.out.println();

        for (int[] b : a) {
            for (int j : b) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}