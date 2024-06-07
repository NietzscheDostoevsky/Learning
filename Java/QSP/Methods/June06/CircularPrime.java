class CircularPrime{

	public static int length(int num){

		int length = 0 ; 

		while(num!=0){

			length++ ;  
			num = num / 10  ; 
		}

		return length ; 
	}

	public static int cyclicPermutation(int num){
		// 1234 -> 2341 ; 2341 -> 3412 ; 

		int next = 0 ; 

		int multiplier = 1; 
		for(int i = 1; i<length(num); i++){
			multiplier = multiplier * 10 ; 
		} 
		next = num % multiplier;
		int digit = num / multiplier ;

		next = next * 10 + digit ;
		return next ;
	}

	public static boolean isPrime(int num){

		
		if(num <=1 ) return false ;
		if(num == 2 ) return true ; 
		if(num%2 == 0) return false ; 

		for(int i = 3; i*i<=num; i+=2){
			if(num%i == 0)
				return false ; 
		}

		return true  ; 
	}

	public static void main(String[] args) {

		boolean flag = true ;
		int num = 19937 ;
		int next ; 
		
		for(int i = 1; i<length(num); i++){
			next = cyclicPermutation(num) ; 
			System.out.print(next + "  : "); 
			System.out.println(isPrime(next)); 
			flag = flag && isPrime(next);
			num = next ;


		}

		if(flag)
			System.out.println("Circular Prime");
		else
			System.out.println("NOT Circular Prime"); 


	}
}