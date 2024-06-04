class TechNumber{
	public static void main(String[] args) {
		
		int num = 0 ; 
		int l = findLength(num);
		System.out.println(l);

		if(l%2 == 0){
			int div = getDivisor(num); 
			//System.out.println(div);

			int fh = num / div ; 
			int lh = num % div ; 

			int add = fh + lh ; 
			int sqr = add * add ; 
			if(sqr == num){
				System.out.println(num + " is a tech number ");

			}else{
				System.out.println(num + " is a not tech number ");	
			}



		}else{
			System.out.println("NOT A TECH NUMBER"); 
		}

	}

	public static int findLength(int num){

		int l = 0;
		while(num>0){
			l++; 
			num/=10;

		}
		return l ; 
	}

	public static int getDivisor(int num){

		int div = 1 ;
		for(int i = 1; i<= findLength(num)/2 ; i++){
			div = div * 10 ; 

		}

		return div ;
	}
}