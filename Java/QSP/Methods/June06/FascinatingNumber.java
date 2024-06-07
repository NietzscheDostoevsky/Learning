class FascinatingNumber{

	public static int length(int num){

		int length = 0 ; 

		while(num!=0){

			length++ ;  
			num = num / 10  ; 
		}

		return length ; 
	}

	public static boolean isFascinating(int num){

		flag = false ; 
		if(len(num)<3)
			return false ; 


		return flag ; 
	}

	public static int nthDigit(int num, int n){
		// returns nth digit from a number num

		int len = length(num); 
		
	}

	public static void main(String[] args) {
		int num = 192 ; 

		if(isFascinating)
			System.out.println(num + " is Fascinating");
		else
			System.out.println(num + " is not Fascinating");

	}


}