package Ola;

public class Auto extends Ola {
	
	String pickupLocation; 
	String dropLocation; 
	double farePrice; 
	
	Auto(String p, String d, double f) {
		this.pickupLocation = p;
		this.dropLocation = d; 
		this.farePrice = f; 
	}
	
	public void AutoMessage() {
		System.out.println("***Auto BOOKED***");
		System.out.println(pickupLocation);
		System.out.println(dropLocation);
		System.out.println(farePrice);
	}

}
