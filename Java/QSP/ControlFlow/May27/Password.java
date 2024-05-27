import java.util.Scanner;
class Password{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int pin1 = 143 ;
		int attempt = 3 ;

		do{
			System.out.print("Enter the pin: ");
			int pin2 = sc.nextInt(); 
			
			if(pin1 == pin2){
				System.out.println("Phone Unlocked");
				break;
			}else{
				System.out.println("Wrong Pin! " + "Attempt left " + (attempt -1));
				if((attempt-1)==0){
					System.out.println("Try after some time");
				}
			}

			attempt--;
		}while(attempt>0);

	}
}