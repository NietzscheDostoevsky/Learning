class ISBN{
	
	// verify ISBN number is valid or not

	public static boolean isISBN(long num){

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