import java.util.Scanner;

class Bank {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String username = null;
		String address = null;
		long adharNumber = 0;
		String panNumber = null;
		int pin = 0;
		double balance = 0;

		for (;;) {
			System.out.println("***Hello Welcome to the bank***");
			System.out.println("");
			System.out.println("1. Create account :");
			System.out.println("2. Existing account holder");
			System.out.println("3. EXIT");
			System.out.println("");
			System.out.print("Enter an option : ");
			int opt = sc.nextInt();
			System.out.println();

			switch (opt) {

				case 1: { // Case 1 : Create Account

					System.out.println("***Option 1: Accout Creation Module***");
					System.out.print("Enter your Name");
					sc.nextLine(); // uncomment this line if there is a problem getting input at
					// runtime
					username = sc.nextLine();
					System.out.print("Address : ");
					address = sc.nextLine();
					System.out.print("Adhaar");
					adharNumber = sc.nextLong();
					System.out.print("Pan Number : ");
					panNumber = sc.nextLine();
					System.out.print("Enter Pin : ");
					pin = sc.nextInt();
					System.out.print("Enter Balance :");
					balance = sc.nextDouble();
					System.out.println("***ACCOUNT CREATED***");

					break;
				}

				case 2: { // Case 2 : Existing accout holder
					for (;;) {
						System.out.println("***WELCOME ACCOUT HOLDER ***");
						System.out.println(" 1. Check Balance");
						System.out.println(" 2. Withdraw");
						System.out.println(" 3. Deposit");
						System.out.println(" 4. Account Details ");
						System.out.println(" 5. Exit");
						System.out.println();

						System.out.print("Enter an option : ");
						int opt1 = sc.nextInt();
						switch (opt1) {
							case 1: {
								System.out.println("Balance : " + balance);
								break;
							}
							case 2: {
								System.out.println("Enter an amount: ");
								double amt = sc.nextDouble();
								if (amt < balance) {
									System.out.println("Amount debited successfully");
									balance = balance - amt;

								} else {
									System.out.println("Insufficielnt Funds");
								}
								break;
							}
							case 3: {
								System.out.println("Enter an amount");
								double amt = sc.nextDouble();
								balance += amt;
								System.out.println("Deposited successfully");
								break;
							}
							case 4: {
								System.out.println("Accoutt details ");
								System.out.println("Username : " + username);
								System.out.println("Account number: 232302323");
								System.out.println("Address : " + address);
								System.out.println("Aadhaar: " + adharNumber);
								System.out.println("Pan Number: " + panNumber);
								break;
							}
							case 5: {
								// System.exit(0);
								break;
							}
						}

					}
				}
				case 3: {
					System.out.println("BYE BYE Logged out");
					System.exit(0); // terminating the execution
					System.out.println("");
					break;
				}
				default: {
					System.out.println("WRONG OPTION !!!");
				}
			}

		}

		// sc.close(); Why not working here ?
	}
}

// Doubts
// sc.close() why code unreacheable erroe
// how to exit infinite for loop ? line 96