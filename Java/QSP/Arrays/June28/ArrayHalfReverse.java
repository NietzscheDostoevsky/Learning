import java.util.Arrays;

class ArrayHalfReverse {

    /*
     * test inputs:
     * 1,2,3,4,5,6,7,8 -> 4,3,2,1,8,7,6,5
     * 1,2,3,4,5 -> 2,1,5,4,3
     */
    public static void main(String[] args) {

        int[] a1 = { 1, 2, 3, 4, 5, 6, 7, 8 };
        int[] a2 = { 1, 2, 3, 4, 5 };
        System.out.println(Arrays.toString(a1));
        System.out.println(Arrays.toString(halfReverse(a1)));
        System.out.println(Arrays.toString(a2));
        System.out.println(Arrays.toString(halfReverse(a2)));

    }

    public static int[] halfReverse(int[] a) {

        int N = a.length;
        int[] c = new int[N];

        if (N % 2 == 0) {
            for (int i = 0; i < N / 2; i++) {
                c[i] = a[N / 2 - 1 - i];
                c[i + N / 2] = a[N - 1 - i];
            }
        } else {

        }
        return c;

    }

    public static int[] reverseArray(int[] a) {
        int N = a.length;
        for (int i = 0; i < N / 2; i++) {
            int temp = a[i];
            a[i] = a[N - 1 - i];
            a[N - 1 - i] = temp;
        }

        return a;
    }

    public static int[] mergeArray(int[] a1, int[] a2) {

        int len = a1.length + a2.length;
        int[] merged = new int[len];
        int indx = 0;
        for (int i : a1)
            merged[indx++] = i;
        for (int i : a2)
            merged[indx++] = i;

        return merged;
    }
}