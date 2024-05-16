import java.util.Scanner ;
class Army{
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in) ; 

		System.out.print("Enter you age : ") ;
		double age = sc.nextDouble();


		if(age < 18) {
			System.out.println("Not eligible") ; 
		} else {
			System.out.println("Enter your height in cms: ");
			double height = sc.nextDouble(); 
			if(height < 162) {
				System.out.println("Not eligible");
			} else {
				System.out.print("Enter your weight: ");
				double weight = sc.nextDouble(); 
				if(weight < 56 ){
					System.out.println("Not Eligible");
				}else{
					System.out.println("Welcome to the army");
				}
			}
		}
	}
}