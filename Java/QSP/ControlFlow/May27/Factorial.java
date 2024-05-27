class Factorial{
	public static void main(String[] args) {
		
		java.util.Scanner sc = new java.util.Scanner(System.in); 

		System.out.print("Enter the number : "); 
		int num = sc.nextInt();
		int prod = 1 ; 

		for(int i = 1; i<=num; i++){
			prod = prod * i ;

		}
		System.out.println(num + "! = " + prod);

		System.out.println();
		System.out.println("-------------");

		int i = 1;
		prod = 1 ; 
		while(i<=num){
			prod = prod * i;
			i++;
		}
		System.out.println(num + "! = " + prod);

		System.out.println();
		System.out.println("-------------");

		i = 1;
		prod = 1; 
		do{
			prod = prod * i;
			i++;
		}while(i<=num);
		System.out.println(num + "! = " + prod);

		System.out.println();
		System.out.println("-------------");

	}
}