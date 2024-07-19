package Ola;

public class Mini extends Ola {
	
	String pickupLocation; 
	String dropLocation; 
	double farePrice; 
	
	Mini(String p, String d, double f) {
		this.pickupLocation = p;
		this.dropLocation = d; 
		this.farePrice = f; 
	}
	
	public void MiniMessage() {
		System.out.println(pickupLocation);
		System.out.println(dropLocation);
		System.out.println(farePrice);
	}

}
