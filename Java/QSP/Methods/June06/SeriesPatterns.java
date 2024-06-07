class SeriesPatterns{

	public static void main(String[] args) {
		
		series1(); 
		System.out.println("\n-------------------------\n");

		series2(); 
		System.out.println("\n-------------------------\n");

		series3(); 
		System.out.println("\n-------------------------\n");

		series4(); 
		System.out.println("\n-------------------------\n");

		series5(); 
		System.out.println("\n-------------------------\n");

		series6(); 
		System.out.println("\n-------------------------\n");

		series7(); 
		System.out.println("\n-------------------------\n");
	}

	public static void series1(){
		// 6 24 12 48 24 96 
		System.out.print("input: " + "6 24 12 48 24 96 -> ");
		int odd = 24 ; 
		int even = 96 ; 
		int next ; 

		for(int i = 1; i<=10; i++){
			if(i%2 != 0 ){
				next = odd * 2 ;
				odd = next ;
			}else{
				next = even * 2 ; 
				even = next ; 
			}
			System.out.print(next + " ");
		}

	}

	public static void series2(){
		// 4 13 -12 37 -84 
		System.out.println("input: " + "4 13 -12 37 -84 ->");

	}

	public static void series3(){
		// 10 12 68 30 222 56
		System.out.println("input: " + "10 12 68 30 222 56 -> ");

	}

	public static void series4(){
		// 5 26 17 124 37 342
		System.out.println("input: " + "5 26 17 124 37 342 -> ");

	}

	public static void series5(){
		// 2 6 22 278 65814
		System.out.println("input: " + "2 6 22 278 65814 -> ");

		// series : prev + 2 pow 2,4,8,16, 32 .... 

		// doubt : how to do it using long 
		double prev = 65814 ; 
		double power = 16 ; 
		
		double next = 0 ; 

		for(int i = 1 ;i<=5; i++){

			next = prev + Math.pow(2, power) ; 
			System.out.print(next + " ");
			power = power * 2 ; 
			prev = next ;

		}


	}

	public static void series6(){
		// 781 783 793 791 805 789
		System.out.println("input: " + "781 783 793 791 805 789 -> ");

	}

	public static void series7(){
		// 1 3 9 33 153 873 
		System.out.print("input: " + "1 3 9 33 153 873 -> ");

		int diff = 720 ; 
		int multiplier = 7 ;
		int next ;
		for(int i = 1 ;i<=5; i++){

			next = diff * multiplier ; 
			System.out.print(next + " ");
			diff++ ; 
			diff = next ; 
		}



	}
}