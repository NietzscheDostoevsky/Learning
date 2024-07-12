package SingleLevelInheritanceExample;

public class Car {
	private String brand;
	private String model;
	private int maxSpeed; // in km/h

	// Constructor
	public Car(String brand, String model, int maxSpeed) {
		this.brand = brand;
		this.model = model;
		this.maxSpeed = maxSpeed;
	}

	// Method to display car details
	public void displayDetails() {
		System.out.println("Brand: " + brand);
		System.out.println("Model: " + model);
		System.out.println("Max Speed: " + maxSpeed + " km/h");
	}
}
