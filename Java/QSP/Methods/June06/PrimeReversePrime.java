class PrimeReversePrime{

	public static void main(String[] args) {
		
		int num = 19 ; 
		System.out.println(isPrime(num));
		System.out.println(reverseNum(num)); 
		if(isPrime(num) == true && isPrime(reverseNum(num))){
			System.out.println("EMIRP");
		}else{
			System.out.println("NOT EMIRP");
		}
	}


	public static boolean isPrime(int num) {
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

    public static int reverseNum(int num ){
    	int rem = 0 ;
    	int reverse = 0 ; 
    	while(num > 0){
    		rem = num % 10 ; 
    		reverse = reverse * 10 + rem ; 
    		num = num / 10 ; 
    	}

    	return reverse ;
    }
}