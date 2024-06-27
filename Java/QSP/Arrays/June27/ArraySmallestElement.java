class ArraySmallestElement {
	
	public static void main(String[] args) {
		int[] a = {4,2,6,1,7,3,5};

	int smallestEle = a[0];
	for(int k = 1; k < a.length; k++){
		if(a[k]<smallestEle){
			smallestEle = a[k];
		}
	}
	System.out.println(smallestEle);
	}
}