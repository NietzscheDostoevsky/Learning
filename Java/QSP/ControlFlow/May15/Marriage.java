import java.util.Scanner ; 

class Marriage{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in) ; 
		System.out.print("Enter Age: ");
		int age = sc.nextInt() ;
		System.out.print("Enter Money : ");
		long money = sc.nextLong();
		System.out.print("Enter Surname: "); 
		String surname = sc.next().strip().toLowerCase() ; 

		if(age > 21) {
			if((money > 1_00_00_000) || (surname.equals("ambani") ) ){ // use surname.equals() method for string comparison
				System.out.print("Eligible");
		}
		}else{
			System.out.print("Not eligible");
		}
		
	}
}

