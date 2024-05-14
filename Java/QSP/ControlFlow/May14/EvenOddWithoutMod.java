class EvenOddWithoutMod{
	public static void main(String[] args) {

		int num1 = 25 ; 
		int half = num1 / 2 ; 
		int sum ; 
		

		sum = half * 2 ; 
		if( sum == num1 ) 
			System.out.println("Even");
		if (sum != num1)
			System.out.println("Odd");
		System.out.println("exit");
	}
}