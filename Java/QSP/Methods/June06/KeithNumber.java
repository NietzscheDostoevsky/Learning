class KeithNumber{

	public static int length(int num){
		// returens length of a number ;

		int length = 0 ; 

		while(num!=0){

			length++ ;  
			num = num / 10  ; 
		}

		return length ; 
	}

	public static void main(String[] args) {
		
		int num = 197 ; 
	}

