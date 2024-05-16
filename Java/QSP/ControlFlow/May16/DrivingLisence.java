import java.util.Scanner ; 
class DrivingLisence {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		
		System.out.print("Enter your age : ") ;
		double age = sc.nextDouble(); 

		if(age<18){
			System.out.println("You are not eligible");
		}else{
			System.out.print("Enter your RTO test marks: "); 
			double marks = sc.nextDouble(); 

			if(marks < 60) {
				System.out.println("Re appear for test") ;
			}else {
				System.out.println("Lisence issued ");
			}
		}


	}
}
