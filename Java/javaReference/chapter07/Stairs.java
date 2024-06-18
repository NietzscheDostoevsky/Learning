class Stairs {
	public static void main(String[] args) {
		
		int n = 7 ;
		System.out.printf("No of ways to cluimb %d stairs: %d \n", n, climb(n));
	}

	public static int climb(int n) {
		if(n == 0) {
			return 1;
		}
		else if(n == 1) {
			return 1; 
		}
		else {
			return climb(n-1) + climb(n-2); 
		}
	}
}