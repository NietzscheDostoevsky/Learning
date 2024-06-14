class Test{
	public static void main(String[] args) {
		
		int p = 9; 
		int q = 6 ; 
		int r = 7 ; 

		if((5&p)<r || q<r){
			q = 9 + r ; 
		}

		if(q == (q^r) + r){
			q = r + r ; 
		}

		q = 9 + p ; 

		int result = p + q + r ; 
	System.out.println(result);
	}
	
}