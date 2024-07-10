package FishTank;

public class Light {
	String brand;
	String color;
	double watt;
	double price;
	
	public Light(String brand, String color, double watt, double price) {
		super();
		this.brand = brand;
		this.color = color;
		this.watt = watt;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Light [brand=" + brand + ", color=" + color + ", watt=" + watt + ", price=" + price + "]";
	}
	
	
	
	
}
