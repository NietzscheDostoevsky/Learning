class AnonArray {
	public static void main(String[] args) {
		evenOdd( new int[] {1,2,3,4,5,6,7,8});
	}

	public static void evenOdd(int[] arr) {
		for (int i: arr) {
			if(i%2 == 0){
				System.out.println(i + "id even. ");
			} else {
				System.out.println(i + "is odd");
			}
		}
	}
}