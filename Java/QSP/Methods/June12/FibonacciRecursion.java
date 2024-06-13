class FibonacciRecursion{

	public static int fibonacciNth(int n){
		
		if(n == 1) return 0 ; 
		if(n == 2) return 1 ;
		else return fibonacciNth(n-1) + fibonacciNth(n-2) ;
	}


	public static void main(String[] args) {

		int num = 10 ;
		for(int i = 1; i<= num; i++)
			System.out.println(fibonacciNth(i));

	}
}