package SingleLevelInheritanceExample;

public class Main {

	public static void main(String[] args) {
		// Creating a Car object
		Car car = new Car("Maruti", "WagonR", 120);
		System.out.println("Car Details:");
		car.displayDetails();
		System.out.println();

		// Creating an F1Car object
		F1Car f1Car = new F1Car("Mercedes", "W12", 350, 2.6);
		System.out.println("F1 Car Details:");
		f1Car.displayDetails();
		System.out.println();

	}

}
