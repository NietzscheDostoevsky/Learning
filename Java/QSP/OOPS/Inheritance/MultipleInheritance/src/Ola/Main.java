package Ola;
import java.util.Scanner;
public class Main {

	OlaUser user;
	Ola o;

	public void rideSuv() {
		o.userDetails();
		Suv ss= (Suv)o;
		ss.suvMessage();
	}

	public void rideAuto() {
		o.userDetails();
		Auto a = (Auto)o;
		a.AutoMessage();
	}

	public void rideMini() {
		o.userDetails();
		Mini m = (Mini) o; 
		m.MiniMessage();
	}

	public static void main(String[] args) {
		Main driver = new Main();
		boolean suvFlag = false;
		boolean autoFlag = false;
		boolean miniFlag = false;
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter username: ");
		String userName = sc.nextLine();
		System.out.print("Enter Wallet money: ");
		double walletMoney = sc.nextDouble();
		
		driver.user = new OlaUser(userName, walletMoney); 
		
		while(true) {
			System.out.println("Accoutn Cration Success" + userName);
			System.out.println("**** WELCOME TO OLA RIDING APPLICATION******");
			System.out.println("Enter your options");
			System.out.println("1. Do you want to ride with SUV");
			System.out.println("2. Do you want to ride with Mini");
			System.out.println("3. Do you want to ride with Auto");
			System.out.println("4. Display your ride :");
			System.out.println("5. Exit");
			int options = sc.nextInt(); 
			switch(options) {
			case 1: {
				suvFlag = true;
				System.out.println("Enter your pickup location: ");
				String pickup = sc.nextLine(); 
				System.out.println("Enter your droplocation: ");
				String drop = sc.nextLine();
				System.out.println("Enter fare price: ");
				double fare = sc.nextDouble();
				driver.o = new Suv(pickup, drop, fare);
			} break; 
			
			case 2: {
				miniFlag = true;
				System.out.println("Enter your pickup location: ");
				String pickup = sc.nextLine(); 
				System.out.println("Enter your droplocation: ");
				String drop = sc.nextLine();
				System.out.println("Enter fare price: ");
				double fare = sc.nextDouble();
				driver.o = new  Mini(pickup, drop, fare);
			} break;
			
			case 3: {
				autoFlag = true; 
				System.out.println("Enter your pickup location: ");
				String pickup = sc.nextLine(); 
				System.out.println("Enter your droplocation: ");
				String drop = sc.nextLine();
				System.out.println("Enter fare price: ");
				double fare = sc.nextDouble();
				driver.o = new Auto(pickup, drop, fare);
			} break; 
			
			case 4: {
				if(suvFlag)
					driver.rideSuv();
				else if(autoFlag)
					driver.rideAuto();
				else if(miniFlag)
					driver.rideMini();
			} break;
			
			case 5: {
				System.out.println("Thank you for your ride");
				System.exit(0);
				
			}
			
			default: {
				System.out.println("Dabba fellow choose the correct option");
			}
				
			} 
		}
		
		
		
	}
}
