package FishTank;

public class FishFood {
		
	String brand;
	double price;
	double quantity;
	
	public FishFood(String brand, double price, double quantity) {
		super();
		this.brand = brand;
		this.price = price;
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "FishFood [brand=" + brand + ", price=" + price + ", quantity=" + quantity + "]";
	}
	
	

}
