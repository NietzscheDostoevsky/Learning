class EvenOddSum{
	public static void main(String[] args) {
		
		int num = 123456789 ;
		int evenSum = 0 ; 
		int oddSum = 0 ; 

		while(num > 0 ){
			int rem = num%10 ;
			if(isEven(rem))
				evenSum += rem ; 
			else if(isOdd(sum))
				oddSum += rem ;
			num /= 10 ; 
		}
	}

	public static boolean isEven(int num ){
		if(num % 2 == 0){
			return true ;
		}

		return false ; 
	}

	public static boolean isOdd(int num ){
		if(num % 2 == 0){
			return false ;
		}

		return true ; 
	}
}