package records;

public record Employee5(String name, int id) {

	public Employee5 {
		name = name.trim();
		int i = name.indexOf(',');
		int j = name.lastIndexOf(',');
		
		if (i != j) throw new IllegalArgumentException("Multiple commas found");
		if (i < 1 | name.length() == i+1) throw new IllegalArgumentException("Required format: last, first");
	}
	
	String lastName() {
		return name.substring(0, name.trim().indexOf(','));
	}
}

class Demo2 {
	public static void main(String[] args) {
		Employee5[] empList = new Employee5[4];
		empList[0] = new Employee5("Doe, John", 1047);
		System.out.println("Last name : " + empList[0].lastName());
		// No comma between last and first name.
		empList[1] = new Employee5("Jones Robert", 1048);
		// Extra commas.
		empList[1] = new Employee5("Jones, ,Robert", 1048);
		// Missing last name.
		empList[1] = new Employee5(", Robert", 1048);
	}
}
