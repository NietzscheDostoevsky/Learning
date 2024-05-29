import java.util.Scanner;

class PatternQuestions{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number of rows: ");
		String input = sc.nextLine(); // Read input as string
        int num;
        
        if (input.isEmpty()) {
            num = 5; // Default value
        } else {
            num = Integer.parseInt(input); // Convert string to integer
        }
        sc.close();

		Pattern1(num);
		System.out.println("\n----------------------");
		Pattern2(num);
		System.out.println("\n----------------------");
		Pattern3(num);
		System.out.println("\n----------------------");
		Pattern4(num);
		System.out.println("\n----------------------");
		Pattern5(num);
		System.out.println("\n----------------------");
		Pattern6(num);
		System.out.println("\n----------------------");
		
		
	}

	public static void Pattern1(int num){
		/*
		1
		2 9
		3 8 10
		4 7 11 14
		5 6 12 13 15 */

		int n = num ; 
		for(int i = 0;i<num; i++){
			for(int j = 0; j<i+1; j++){
				int x = 0 ; 
				for(int k = 0; k<j+1; k++){
					x = x + n - k ;
				}
				if(j%2 == 0){
					System.out.print((x+i-j+1) + " " ) ; 
				}else{
					System.out.print((x+n-1) + " "); 
				}
				
			}
			System.out.println(); 

		}
	}

	public static void Pattern2(int num){
		/*
		1
		0 1
		1 0 1
		0 1 0 1
		1 0 1 0 1
		0 1 0 1 0
		*/

		for(int i = 0; i<num; i++){
			for(int j = 0; j<=i; j++){
				if((i+j)%2 == 0){
					System.out.print(0 + " ");
				}else{
					System.out.print(1 + " ");
				}
			}
			System.out.println();
		}
	}

	public static void Pattern3(int num){
		/*
		1
		1 0 
		1 0 1
		1 0 1 0 
		1 0 1 0 1
		*/
		for(int i = 0; i<num; i++){
			for(int j = 0; j<=i; j++){
				if((j)%2 == 0){
					System.out.print(1 + " ");
				}else{
					System.out.print(0 + " ");
				}
			}
			System.out.println();
		}

	}
	
	
	public static void Pattern4(int num){
		/*
		0
		1 1
		2 3 5
		8 13 21 34
		55 
		*/

		int pointer = 1 ; // starting from first term
		for(int i = 0; i<num; i++){
			for(int j = 0; j<=i; j++){
				System.out.print(FibonacciNth(pointer) + " "); 
				pointer++;
				
			}
			System.out.println();
		}

	}
	public static void Pattern5(int num){
		/*
		2
		3   5 
		7  11 13
		17 19 23 29
		*/
	}
	public static void Pattern6(int num){
		/*
		1
		2 6
		3 7 10
		4 8 11 13
		5 9 12 14 15
		*/
	}

	public static int FibonacciNth( int n){
		// Returns nth fibonacci term 
		if(n==1)
			return 0 ;
		if(n==2)
			return 1; 

		int a = 0 ; 
		int b = 1 ; 
		int next = 1 ; 

		for(int i = 3; i<=n; i++){
			next = a + b ; 
			a = b ; 
			b = next ; 

		}
		return next ; 
	}

	public static int PrimeNth

}