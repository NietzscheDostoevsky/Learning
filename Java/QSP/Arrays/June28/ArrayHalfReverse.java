import java.util.Arrays;
class ArrayHalfReverse {

    /*
     * test inputs: 
     *      1,2,3,4,5,6,7,8 -> 4,3,2,1,8,7,6,5
     *      1,2,3,4,5       -> 2,1,5,4,3
     */
    public static void main(String[] args) {

        int[] a1 = {1,2,3,4,5,6,7,8};
        int[] a2 = {1,2,3,4,5};
        System.out.println(Arrays.toString(a1));
        System.out.println(Arrays.toString(halfReverse(a1)));
        System.out.println(Arrays.toString(a2));
        System.out.println(Arrays.toString(halfReverse(a2)));

        
    }

    public static int[] halfReverse(int[] a) {

        int[] c = new int[a.length];
        for(int i = 0; i < a.length/2; i++){
            c[i] = 
        }

        return c;

    }
}