package com.Relationship;

class Car {  // parent class
	String brand;
	String modelNo;
	String type;
	double mileage;
	int seatingCapacity;
	double price;
	Engine engine ; 
	//Engine engine = new Engine("DADA", 1000, 12, 10000, "Petrol");
	
	Car (String brand, String modelNo, String type, double mileage, int seatingCapacity, double price , String e, double b, int n, int r, String f) {
		this.brand = brand;
		this.modelNo = modelNo; 
		this.type = type; 
		this.mileage = mileage ;
		this.seatingCapacity = seatingCapacity;
		this.price = price;
		this.engine = new Engine(e,  b,  n,  r,  f);
		// 
		// this.engine = new Engine("DADA", 1000, 12, 10000, "Petrol");
		
	}
	
	Car (String brand, String modelNo, String type, double mileage, int seatingCapacity,double price, Engine e) {
		this.brand = brand;
		this.modelNo = modelNo; 
		this.type = type; 
		this.mileage = mileage ;
		this.seatingCapacity = seatingCapacity;
		this.price = price;
		this.engine = e;		
	}
	
	
	void displayCar () {
		System.out.println("**** CAR DETAILS ****");
		System.out.println("Brand: " + this.brand);
		System.out.println("Model No : " + this.modelNo) ;
		System.out.println("Type : " + this.type);
		System.out.println("Mileage: " + this.mileage );
		System.out.println("Seating Capacity: " + this.seatingCapacity);
		System.out.println("Price: " + this.price);
	}
	
	
	
}

class Engine { // child class
	String engineType;
	double bhp;
	int noOfPistons;
	int rpm;
	String fuel;
	
	Engine(String e, double b, int n, int r, String f) {
		this.engineType = e;
		this.bhp = b;
		this.noOfPistons = n;
		this.rpm = r;
		this.fuel = f;
	}
	
	void displayEngine() {
		System.out.println("*** ENGINE DETAILS ***");
		System.out.println("Engine Type" + engineType);
		System.out.println("BPH " + bhp);
		System.out.println("RMP: " + rpm);
		System.out.println("fuel :" + fuel);
	}
}


public class CompositionExample {
	public static void main(String[] args) {
		
		Car obj = new Car("TATA", "NEXON", "HATCHBACK", 17, 5, 850000, "DADA", 1000, 12, 10000, "Petrol");
		Car obj2 = new Car("MARUTI", "WAGONR", "HATCHBACK", 18, 1, 550000, (new Engine("HONDA", 7000, 2, 5000, "Petrol")));
		obj.displayCar();
		obj.engine.displayEngine();
		
		obj2.displayCar();
		obj2.engine.displayEngine();
		
		
	}

}
