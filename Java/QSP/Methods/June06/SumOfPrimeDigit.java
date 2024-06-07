class SumOfPrimeDigit{
	public static void main(String[] args) {
		int num = 123456 ; 
		System.out.println(isPrime(13));
		int sum = 0 ; 
		while(num>0){
			int rem = num%10 ; 
			if(isPrime(rem)){
				sum = sum + rem ; 
			}
			num = num / 10 ; 
		}
		System.out.println(sum);
		

	}

	public static boolean isPrime(int num){
		
		if(num<2)
			return false;
		if(num==2)
			return true ;
		
		for( int i = 3; i*i<=num; i= i+2){
			if(num%i == 0){
				return false;
			}
		}
		return true ; 
	}

		public static boolean IsPrime(int num) {
        if (num <= 1) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;

        for (int i = 3; i * i <= num; i += 2) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }	
}