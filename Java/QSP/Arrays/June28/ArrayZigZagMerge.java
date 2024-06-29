import java.util.Arrays;
class ArrayZigZagMerge {

	public static void main(String[] args) {
		// same size arrays 
		// int[] a = {1,2,3};
		// int[] b = {4,5,6};
		// System.out.println(Arrays.toString(a));
		// System.out.println(Arrays.toString(b));

		// // new array to be merged in
		// int [] narr = new int[a.length + b.length];

		// for (int i = 0, j=0; i < a.length; i++){
		// 	narr[j++] = a[i];
		// 	narr[j++] = b[i];
		// }

		// System.out.println(Arrays.toString(narr));

		int[] a = {1,2,3,5,6,7,8,8,9};
		int[] b = {4,5,6,7,8};
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(b));

		int l1 = a.length; int l2 = b.length ;
		int large ;
		if(l1>l2){
			large = l1;
		} else {
			large = l2;
		}

		int small ;
		if(l1!=large){
			small = l1;
		} else {
			small = l2;
		}

		// new array to be merged in
		int [] narr = new int[a.length + b.length];

		for (int i = 0, j=0; i < large; i++){
			if(i<small)
				narr[j++] = a[i];
			narr[j++] = b[i];
		}

		System.out.println(Arrays.toString(narr));
	}
}