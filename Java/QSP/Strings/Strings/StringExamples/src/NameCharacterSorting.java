import java.util.Scanner;

public class NameCharacterSorting {
    public static void main(String[] args) {
        String name = "Saurabh";

    }

    public static <T extends Comparable<T>> void bubbleSort(T[] arr) {
        int n = arr.length;
        boolean swapped;

        for(int i = 0; i < n - 1; i++) {
            if (arr[j].compareTo(arr[j + 1]) > 0) {
                T temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
                swapped = true;
            }
        }
        if(!swapped) break;\
    }
}
