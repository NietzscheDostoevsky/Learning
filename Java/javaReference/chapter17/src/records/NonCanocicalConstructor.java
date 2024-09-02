package records;

record Employee2(String name, int idNum) {
	static int pendingID = -1;
	
	Employee2 {
		name = name.trim();
	}
	
	Employee2(String name) {
		this(name, pendingID);
	}
}

public class NonCanocicalConstructor {

	public static void main(String[] args) {
		Employee2[] empList = new Employee2[4];
		
		empList[0] = new Employee2("Doe, John", 1047);
		empList[1] = new Employee2("Jones, Robert", 1048);
		empList[2] = new Employee2("Smith, Rachel", 1049);
		// Here, the ID number is pending.
		empList[3] = new Employee2("Martin, Dave");
		// Display names and IDs.
		for(Employee2 e: empList) {
			System.out.print("The employee ID for " + e.name() + " is ");
			if(e.idNum() == Employee2.pendingID) 
				System.out.println("Pending");
			else 
				System.out.println(e.idNum());
		}
		
		System.out.println(empList[3]);
	}
}