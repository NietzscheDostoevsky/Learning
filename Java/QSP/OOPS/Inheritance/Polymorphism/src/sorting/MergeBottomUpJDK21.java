package sorting;

@SuppressWarnings({"rawtypes"})
public class MergeBottomUpJDK21 {

    public static void main(String[] args) {
        Integer[] a = {9,8,7,6,5,4,3,2,1,0};
        sort(a); 
        assert isSorted(a); 
        System.out.println("Array is Sorted");
        show(a); 
    }

    // ***********************************************
    // Helper functions for main() 

    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }   

    private static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) 
            if (less(a[i-1], a[i]))
                return false; 
        return true;
        
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0; 
    }  

    // ****************************************************

    // Class methods 
    private static Comparable[] aux; 
    public static void sort(Comparable[] a) {
        int N = a.length; 
        aux = new Comparable[N];
        for (int sz = 1; sz < N; sz = sz + sz) 
            for (int lo = 0; lo < N - sz; lo += sz + sz )
                merge(a, lo, lo+sz-1, Math.min(lo+sz+sz-1, N-1));
    }

    private static void merge(Comparable[] a, int lo, int mid, int hi) {
        // merges two sorted arrays in sorted order. 
        int i = lo, j = mid + 1; 
        for (int k = lo; k<=hi; k++) 
            aux[k] = a[k] ; 
        for (int k = lo; k <= hi; k++) {
            if (i > mid) a[k] = aux[j++]; 
            else if (j > hi) a[k] = aux[i++];
            else if (less(aux[j], aux[i])) a[k] = aux[j++];
            else a[k] = aux[i++];
        }
    }

}