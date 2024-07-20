package Ola;

public class Suv extends Ola{

	String pickupLocation; 
	String dropLocation; 
	double farePrice; 
	
	Suv(String p, String d, double f) {
		this.pickupLocation = p;
		this.dropLocation = d; 
		this.farePrice = f; 
	}
	
	public void suvMessage() {
		System.out.println("***SUV BOOKED***");
		System.out.println(pickupLocation);
		System.out.println(dropLocation);
		System.out.println(farePrice);
	}
	
}
