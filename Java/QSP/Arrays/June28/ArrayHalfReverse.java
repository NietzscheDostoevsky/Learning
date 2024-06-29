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

        c = mergeArray(reverseArray(splitArray(a, 0, N / 2)),
                reverseArray(splitArray(a, N / 2, N)));

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

    public static int[] splitArray(int[] a, int lo, int hi) {
        // splits the arrray and return the subarray between lo and hi index
        // lo inclusive, hi exclusive
        int LEN = hi - lo;
        int[] c = new int[LEN];
        for (int i = 0; i < LEN; i++) {
            c[i] = a[lo++];
        }

        return c;
    }
}