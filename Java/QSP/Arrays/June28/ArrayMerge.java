class ArrayMerge {
	public static void main(String[] args) {
		
		int[] a1 = {
			1,2,3,4,5,6
		};
		int[] a2 = {
			7,8,9,10
		};

		int len = a1.length + a2.length ;
		int[] merged = new int[len];

		for(int i=0;i<a1.length;i++){
			merged[i] = a1[i];
		}

		for(int i=0;i<a2.length;i++){
			merged[i + a1.length] = a2[i];
		}

		System.out.println(java.util.Arrays.toString(merged));

		// using for each 
		int[] c = new int[len];
		int indx = 0;
		for(int i:a1)
			c[indx++] = i;
		for(int i:a2)
			c[indx++] = i;
		System.out.println(java.util.Arrays.toString(merged));
	}
}