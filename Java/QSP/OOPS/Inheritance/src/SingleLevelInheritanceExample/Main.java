package SingleLevelInheritanceExample;

public class Main {

	public static void main(String[] args) {
		// Creating a Car object
//		Car car = new Car("Maruti", "WagonR", 120);
//		System.out.println("Car Details:");
//		car.displayDetails();
//		System.out.println();
//
//		// Creating an F1Car object
//		F1Car f1Car = new F1Car("Mercedes", "W12", 350, 2.6);
//		System.out.println("F1 Car Details:");
//		f1Car.displayDetails();
//		System.out.println();
//		
		// Creating a RedBull object 
		
		RedBull RB20 = new RedBull("RedBullRacing", "RB20", 377, 2.1, "2024", "Max Verstappan", "Checo Perez", "Honda");
		RB20.displayRedBull();
		
		int var =10;
		System.out.println(var);

	}

}
