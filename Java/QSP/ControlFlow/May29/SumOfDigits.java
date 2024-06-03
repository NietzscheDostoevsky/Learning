class SumOfDigits{
	
	public static void main(String[] args) {
		
		int num = 1187  ;

		int sum = 0 ; 

		for(int i = num; i!= 0; i = i/10){
			sum = i%10 + sum;
		}
		System.out.println(num);
		System.out.println(sum);
	}
}