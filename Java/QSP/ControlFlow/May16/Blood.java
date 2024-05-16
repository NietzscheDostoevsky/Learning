import java.util.Scanner ; 

class Blood{
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in) ;
		System.out.print("Enter your age : ");
		double age = sc.nextDouble(); 

		if (age<20) {
			System.out.println("You can't donte blood "); ; 
		} else {
			System.out.print("Have you consumed alcohol or cigerette in last 24 hours true/false : ");
			//char alcohol = sc.next().toLowerCase().charAt(0);
			boolean alcohol = sc.nextBoolean() ; 

			//if(alcohol == 'y'){
			if(alcohol == true){
				System.out.println("You can't donte blood "); ; 
			} else {
				System.out.print("Enter your weight : ");
				double weight = sc.nextDouble(); 
				if(weight < 50 ){
					System.out.println("You can't donte blood ");;
				}else{
					System.out.println("You can donate blood");
				}
			}
		}

		
	}
}