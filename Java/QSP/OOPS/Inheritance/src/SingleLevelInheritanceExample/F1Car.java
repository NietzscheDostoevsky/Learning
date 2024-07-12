package SingleLevelInheritanceExample;

public class F1Car extends Car {
    private double acceleration; // 0 to 100 km/h in seconds

    // Constructor
    public F1Car(String brand, String model, int maxSpeed, double acceleration) {
        super(brand, model, maxSpeed);
        this.acceleration = acceleration;
    }

    // Method to display F1 car details
    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Acceleration (0 to 100 km/h): " + acceleration + " seconds");
    }
}
