class Student {
	String sname; 
	String nplace ;
	String education;
	String branch; 
	int yop;
	double cgpa;
	long contactNumber;
	static String college = "IITD";

	public void displayStudentDetails(){
		System.out.println("*** Student Info ****");
		System.out.println("Name: " + sname);
		System.out.println("Native Place: " + nplace);
		System.out.println("Education: " + education);
		System.out.println("Branch: " + branch);
		System.out.println("Year of Passout: " + yop);
		System.out.println("CGPA: " + cgpa);
		System.out.println("Contact Number : " + contactNumber);
		System.out.println("College : " + college);
		System.out.println();
	}
}

class StudentDriver {
	// driver method always contains the main method 
	// it drives the executino 
	public static void main(String[] args) {
		Student obj = new Student();
		System.out.println(obj);
		obj.sname = "Jayasurya";
		obj.nplace = "Kohlapur"; 
		obj.education = "BCA"; 
		obj.branch = "Computer Science"; 
		obj.yop = 2023; 
		obj.cgpa = 7.77; 
		obj.contactNumber = 9898989898l; 
		obj.college = "HAHA";

		obj.displayStudentDetails(); 
		Student obj2 = new Student();
		obj2.displayStudentDetails(); 

		 

	}
}