class Resistration {
	String username ; 
	String emailId; 
	long phoneNumber;
	long altphoneNumber;
	String dob;
	String gender;

	Resistration(String username, 
				 String emailId,
				 long phoneNumber,
				 String gender) {
		// constructor for registration form 
		super();
		this.username = username;
		this.emailId = emailId;
		this.phoneNumber = phoneNumber;
		this.gender = gender;
	}

	Resistration(String username, 
				 String emailId,
				 long phoneNumber,
				 long altphoneNumber,
				 String gender
				 ) {
		// constructor for registration form 
		super();
		this.username = username;
		this.emailId = emailId;
		this.phoneNumber = phoneNumber;
		this.altphoneNumber= altphoneNumber;
		this.gender = gender;
	}

	void displayRegistration() {
		System.out.println("***USER DETAILS***");
		System.out.println("Username:" + username);
		System.out.println("email: " + emailId);
		System.out.println("Phone Number: " + phoneNumber);
		System.out.println("Alt Phone: " + altphoneNumber);
		System.out.println("Dob" + dob);
		System.out.println("Gender: " + gender);
	}
}

class RegistrationDriver {
	public static void main(String[] args) {
		
		Resistration obj = new Resistration("Ramesh", "ramessh123@gmail.com,",
											 9898989898l, "Male");
		System.out.println(obj.username);
		System.out.println(obj.emailId);
		System.out.println(obj.phoneNumber);
		System.out.println(obj.altphoneNumber);
		System.out.println(obj.dob);
		System.out.println(obj.gender);

		obj.displayRegistration();

	}
}