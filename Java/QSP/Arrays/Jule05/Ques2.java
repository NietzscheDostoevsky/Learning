class Ques2 {

	// write a java program to finnd leader in an array 
	// for eg by comparing current index with right side elements.
	//  The present element should be largest then only print 
	// input :{16 17 15 4 5 3 2}   output : {17 15 5 2}  

	public static void main(String[] args) {
		int[] arr = { 16, 17, 15, 4, 5, 3, 2};
	for (int i = 0; i < arr.length - 1; i++) {
		if((arr[i] < arr[i + 1]) && (i!= arr.length -1)) {
			System.out.println(arr[i]);
		}
	}
	}
}


