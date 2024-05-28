import java.util.Scanner ;

class Factor{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 

		System.out.print("Enter the number : ");
		int num = sc.nextInt(); 

		for(int i = 1 ; i<=num; i++){
			if(num%i == 0){
				System.out.print(i + " "); 
			}
		}
		System.out.println();
		System.out.println("---------------------");
		int i = 1 ; 
		while(i<=num){
			if(num%i == 0){
				System.out.print(i + " "); 
			}
			i++;
		}

		System.out.println();
		System.out.println("---------------------");

		i = 1 ; 
		do{
			if(num%i == 0){
				System.out.print(i + " "); 
			}
			i++;
		}while(i<=num);
	}
}