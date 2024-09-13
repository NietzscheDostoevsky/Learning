package ecommerceAmazon;

import java.util.Scanner;

public class Welcome {
	static Scanner sc = new Scanner(System.in);
	User user ;
	public void welcomeUser() {
		
		for (;;) {
			System.out.println();
			System.out.println("*** WELCOME JMART****");
			System.out.println();
			System.out.println("1. New User");
			System.out.println("2. Existing User");
			
			System.out.println();
			System.out.print("Enter an option: ");
					
			int option = sc.nextInt();
			switch(option) {
			case 1 -> resiterNewUser();
			case 2 -> loginUser();
			default -> System.out.println("Wrong option entered. ");
			}
		}
	}

	private void loginUser() {
		
		if(user !=null) {
			for (int i = 1; i <=3; i++) {
				System.out.println();
				System.out.println("LOGIN MODULE");
				System.out.println();
				System.out.print("Enter username/Phone");
				String cred = sc.nextLine();
				System.out.println("Password");
				String passString = sc.nextLine();
				System.out.println();
				
				if (user.userName.equals(cred) || 
						user.phoneNumber.equals(cred) && 
						user.password.equals(passString)) {
					
					HomePage homePage = new HomePage(user);
					homePage.shopByCategory();
				} else {
					System.out.println("Wrong credentials. ");
				}
			}
		} else {
			System.out.println();
			System.out.println("Create account first");
		}
		
	}

	private void resiterNewUser() {
		System.out.println();
		System.out.println("*** REgistration Module ****");
		System.out.println();
		System.out.println("Username: ");
		String username = sc.nextLine();
		System.out.println("Phone Number: ");
		String phoneNumber = sc.next();
		System.out.println("Password");
		String password = sc.next();
		System.out.println("Address");
		String address = sc.next();
		user = new User(username, password, phoneNumber, address);
		
		System.out.println("Account created successfully");
		
	}
}
