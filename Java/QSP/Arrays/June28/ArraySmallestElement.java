public class ArraySmallestElement {
    public static void main(String[] args) {
        int[] a = {
                1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11
        };
        //smallest element
        int smallest = a[0];
        int secondSmallest = a[0];
        for (int ele : a) {
            if (ele < smallest) {
                secondSmallest = smallest;
                smallest = ele;
            } else if(ele < secondSmallest && ele != smallest) {
                secondSmallest = ele;
            }
        }
        System.out.println(smallest);
        System.out.println(secondSmallest);

        //seciond smallest 

    }
}
