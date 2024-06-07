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
        int num2 = num ; 
		int len = length(num);
		System.out.println("num: " + num);
		System.out.println("len :" + len);

		int numSum = 0 ; 

		for(int i = 1; i<=len; i++){

			System.out.println(num2%10);
			numSum +=  num2%10 ; 
			num2/=10; 
		}
		System.out.println("numsum:" + numSum);

        int next = 0  ; 
        for(int i = 1 ; i<=(len-1); i++){
            next += num% 10 ; 
            num /= 10 ; 
        }
        System.out.println(next);
        next = next + numSum ; 
        System.out.println("next: " + next);
	}

}