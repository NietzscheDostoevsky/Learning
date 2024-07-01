package com.Saurabh;

public class RegGoogle {
	
	String firstName ; 
	String lastName; // non mandatory
	String emailId;
	String password;
	String dob;
	String gender; 
	long con ; // non mandatoroy
	
	public RegGoogle(String ...strings) {
		
		System.out.println("Hi I got invoked ");
		
	}
	
	public static void main(String[] args) {
		
		RegGoogle google1 = new RegGoogle("Ramesh", "Kumar", "kumar123@gmail.com", "kumar123" , "01/01/2000","Male", 8989898989l);
		RegGoogle google2 = new RegGoogle("Suresh", "haha", "sureh@gmail.com", "kumar123" , "01/01/2000");
		RegGoogle google3 = new RegGoogle("Ganesh", "Kumar", "kumar123@gmail.com", "kumar123" , "01/01/2000", "Male");
		RegGoogle google4 = new RegGoogle("Mahesh", "Kumar", "kumar123@gmail.com", "kumar123" , "01/01/2000", 8989898989l);
		
		
	}

	
	

}
