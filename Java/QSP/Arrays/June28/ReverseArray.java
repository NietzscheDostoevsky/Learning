class ReverseArray {
	public static void main(String[] args) {
		
		int[] a = { 1,2,3,4,5,6,7};
		System.out.println(java.util.Arrays.toString(a));

		for(int i = a.length-1; i>=0; i--){
			System.out.print(a[i]+ " ") ;
		}

		int N = a.length;
		for(int i = 0; i<N/2; i++) {
			int temp = a[i];
			a[i] = a[N - 1 - i];
			a[N - 1 - i] = temp;
		}
		System.out.println(java.util.Arrays.toString(a));
	}
} 