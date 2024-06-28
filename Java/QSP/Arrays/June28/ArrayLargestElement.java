public class ArrayLargestElement {
    public static void main(String[] args) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MAX_VALUE;

        int[] arr = {
                1, 2, 3, 4, 5, 6, 7, 8, 9, 10
        };

        for (int a : arr) {
            if (a > largest) {
                secondLargest = largest;
                largest = a;
            } else if (a > secondLargest && a != largest) {
                secondLargest = a;
            }
        }
        System.out.println(largest);
        System.out.println(secondLargest);
    }
}
