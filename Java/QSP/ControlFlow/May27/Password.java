import java.util.Scanner;
class Password{
	public static void main(String[] args) throws InterruptedException {
		Scanner sc = new Scanner(System.in);
		int pin1 = 143 ;
		int duration = 2000;

		outerloop:
		for(;;){
			int attempt = 3 ;
			do{
			System.out.print("Enter the pin: ");
			int pin2 = sc.nextInt(); 
			
			if(pin1 == pin2){
				System.out.println("Phone Unlocked");
				break outerloop;

			}else{
				System.out.println("Wrong Pin! " + "Attempt left " + (attempt -1));
				if((attempt-1)==0){
					System.out.println("Try after some time");
					Thread.sleep(duration);
				}
			}

			attempt--;
			}while(attempt>0);
		}

	}
}