import java.util.Scanner ; 
class Table{
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a number : ");
		int input = sc.nextInt(); 

		for(int i=1; i<=10; i++){
			System.out.println(input + " X " + i + " = " + i*input );

		}
		System.out.println("------------------------------");
		int i = 1;
		while(i<=10){
			System.out.println(input + " X " + i + " = " + i*input );
			i++;
		}
		System.out.println("------------------------------");
		i = 1 ;
		do{
			System.out.println(input + " X " + i + " = " + i*input );
			i++;
		}while(i<=10);
	}
}