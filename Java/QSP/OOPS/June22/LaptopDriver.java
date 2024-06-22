class Laptop {
	String brand;
	String model;
	String color;
	

	Laptop(String brand, String model, String color) {
		this.brand = brand;
		this.model = model;
		this.color = color;

	}

	Laptop(Laptop obj) {
		this.brand = obj.brand;
		this.model = obj.model;
		this.color = obj.color;
	}

	void displayLaptop() {
		System.out.println("***Laptop Details***");
		System.out.println("Brand : " + brand);
		System.out.println("Model : " + model);
		System.out.println("Color : " + color);
	}
}

class LaptopDriver {
	public static void main(String[] args) {
		
		Laptop obj = new Laptop("Dell", "Gaming", "Black");
		obj.displayLaptop();

		Laptop obj1 = new Laptop(obj);
		obj.displayLaptop();

	}
}