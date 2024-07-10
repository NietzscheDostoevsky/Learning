package FishTank;

public class OxygenPump {

	String brand;
	double price;
	double pumpingCapacity;
	double voltage;
	
	public OxygenPump(String brand, double price, double pumpingCapacity, double voltage) {
		super();
		this.brand = brand;
		this.price = price;
		this.pumpingCapacity = pumpingCapacity;
		this.voltage = voltage;
	}

	@Override
	public String toString() {
		return "OxygenPump [brand=" + brand + ", price=" + price + ", pumpingCapacity=" + pumpingCapacity + ", voltage="
				+ voltage + "]";
	}
	
	
	
	
}
