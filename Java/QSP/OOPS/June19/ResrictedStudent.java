class Student {

	// static variable to keep track of the number of instances. 
	private static int instanceCount = 0;

	// max num of allowed instances 
	private static final int MAX_INSTANCES = 10;

	// Private constructor to prevent direct instantiation
	private Student() {
		// private so that it can't be accessed from outside the class
		// and no instances can be created without keeping a count
	}

	// static method whihc can be called from outside and keeps a count 
	// of number of instances created and returns an object of student class 

	public static Student createStudent() {
		if(instanceCount < MAX_INSTANCES) {
			instanceCount++;
			return new Student();
		} else {
			System.out.printf("Max limit for student class %d reached \n", MAX_INSTANCES);
			return null; 
		}
	}

	// returns the number of instances already created 
	public static int getInstanceCount() {
		return instanceCount; 
	}

}

class StudentDriver {
	public static void main(String[] args) {

		// trying to create more than 10 instances
		for(int i = 1; i < 15; i++) {
			Student student = Student.createStudent();
			if(student != null) {
				System.out.println("Student instance " + i + " created" );
			}
		}
	System.out.println("Total number of student instances created: " + Student.getInstanceCount());
	}


}