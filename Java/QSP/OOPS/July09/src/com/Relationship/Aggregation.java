package com.Relationship;

//implements date type which takes less data size in memory
//but takes cpu cycles to calculate the end date. 

class Date {
	private final int value;

	public Date(int d, int m, int y) {
		this.value = y * 512 + m * 32 + d;
	}

	public int month() {
		return (value / 32) % 16;
	}

	public int day() {
		return value % 32;
	}

	public int year() {
		return value / 512;
	}

	public String toString() {
		return day() + "/" + month() + "/" + year();
	}
}

class Student {
	 
	Date dobDate ; 
	String name ;
	
	public Student(Date dob, String name) {
		this.dobDate = dob; 
		this.name = name; 
	}
	
	public void showStudentDetails() {
		System.out.println("*** Student Detaisl ***");
		System.out.println("Name: " + this.name);
		System.out.println("Student DOB: " + dobDate.toString() + "\n");
	}
		
}

class Institute {
	Student student ; 
	Date registrationDate ; 
	
	public Institute(Student student, Date regDate) {
		this.student = student ; 
		this.registrationDate = regDate; 
	}
	
	
	
	void showInstituteDetails() {
		int age =  this.registrationDate.year() - this.student.dobDate.year() ;
		System.out.println("*** Institute Details ***");
		System.out.println("Student Name: " + this.student.name);
		System.out.println("Student Age: " + age + "years");
		System.out.println("Registraton Date : " + this.registrationDate.toString() + "\n" );
	}
}

public class Aggregation {

	public static void main(String[] args) {
		
		Student s1 = new Student((new Date(12,1, 2020)), "Dinga");
		Institute QSP = new Institute(s1, (new Date(07, 10, 2024)));
		
		s1.showStudentDetails();
		QSP.showInstituteDetails();
		
		
		
	}

}
