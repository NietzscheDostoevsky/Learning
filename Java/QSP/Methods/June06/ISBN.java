class ISBN{
	
	// verify ISBN number is valid or not

	public static boolean isISBN(long num){

		long sum = 1l ; 
		long i = 1l ;
		while(num!=0){

			sum += num%10 * i ; 
			i++ ; 
			num/=10 ; 
		}

		System.out.println(sum);
		if(sum%6 == 0) return true ;

		return false ;
	}

	public static void main(String[] args){

		long num = 1259060977l ; 
		long num2 = 8147852369l ;

		if(isISBN(num))
			System.out.println(num + " : Is leagl ISBN");
		else
			System.out.println(num + " : Is not a legal ISBN");
	}


}