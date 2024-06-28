class ArrayPrint1D {
	public static void main(String[] args) {

		int[] arr = { 1, 2, 3, 4, 5, 6, 7 };

		// for loop
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		// while loop

		int j = 0;
		while (j < arr.length) {
			System.out.print(arr[j] + " ");
			j++;
		}
		System.out.println();

		// do while
		int k = 0;
		do {
			System.out.print(arr[k] + " ");
			k++;
		} while (k < arr.length);
		System.out.println();

		// for each

		for (int m : arr) {
			System.out.print(m + " ");
		}
	}

}