class Patterns{
	public static void main(String[] args) {
		
		int n = 9 ; 

		SquareDiagonal(n);
		System.out.println() ; 
		AlphanumericSquare(); 

	}

	public static void SquareDiagonal(int n){

		for(int i = 0; i < n ; i++){
			for(int j = 0; j < n ; j++){
				if(i == 0 || i == n-1 || j == 0 || j == n-1 || i == j || i+j == n-1){
					System.out.print("* "); 
				}else{
					System.out.print("  ");
				}
			}
			System.out.println();

		}		
	}

	public static void AlphanumericSquare() {

		int n = 4 ; 
		char alpha = 'a' ; 
		int num = 8 ;

		for (int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j< n; j++){
				if(i%2 == 0){
					System.out.print(alpha); 
					alpha++; 
				}else{
					System.out.print(num); 
					num--;
				}
			}
			System.out.println();
		}
	}

}
