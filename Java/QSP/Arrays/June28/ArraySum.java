class ArraySum {
    public static void main(String[] args) {

        // sum of all elements
        int[] a = {
                1, 2, 3, 4, 5, 6, 7
        };

        int sum = 0;
        for (int element : a) {
            sum += element;
        }
        System.out.println(sum);

        // sum of even elements
        sum = 0;
        for (int element : a) {
            if (element % 2 == 0)
                sum += element;
        }
        System.out.println(sum);

        // sum of odd index elemnents
        sum = 0;
        for (int i = 0; i < a.length; i++) {
            if (i % 2 != 0) {
                sum += a[i];
            }
        }
        System.out.println(sum);

    }
}