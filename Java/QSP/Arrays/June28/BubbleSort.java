class BubbleSort {
	public static void main(String[] args) {

		int[] arr = {2,4,1,3, 2,3,4,1, 7};
		System.out.println(java.util.Arrays.toString(arr));

		for(int i = 0; i<arr.length; i++){
			for(int j = i + 1; j<arr.length; j++){
				if(arr[i] > arr[j]){
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		System.out.println(java.util.Arrays.toString(arr));
	}
}