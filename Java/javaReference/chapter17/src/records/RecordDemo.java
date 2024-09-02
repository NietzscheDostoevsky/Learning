package records;



public class RecordDemo {

	public static void main(String[] args) {
		record Employee(String name, int id) {};
		Employee[] empList = new Employee[4];
		
		empList[0] = new Employee("Doe", 1057);
		empList[1] = new Employee("Jones, Robert", 1048);
		empList[2] = new Employee("Smith, Rachel", 1049);
		empList[3] = new Employee("Martin, Dave", 1050);
		
		for (Employee e: empList)
			System.out.println("The employee ID for " + e.name() + " is " +
					e.id());
		
		System.out.println(empList[0]);
	}

}
