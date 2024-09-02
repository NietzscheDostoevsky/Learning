package records;

public record Employee(String name, int id) {
	//Canonical constructor which removes trailing whitespaces
	public Employee(String name, int id) {
		this.name = name.trim();
		this.id = id;
	}
}

record Employee3(String name, int id) {
	Employee3 {
		name = name.trim();
	}
}

class Demo {
	public static void main(String[] args) {
		System.out.println(new Employee(" Saurabh  ", 10101));
	}
}