class SumOfEvenNumbers{
	public static void main(String[] args) {
		
		int num = 20 ; 
		int sum = 0;

		for(int i=1;i<=num; i++){

			if(i%2==0){
				sum += i ;
			}

		
		}
		System.out.println("Sum of 20 even numbers : " + sum) ;

	}	
}