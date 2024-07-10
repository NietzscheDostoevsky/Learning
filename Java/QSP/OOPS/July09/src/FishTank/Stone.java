package FishTank;

public class Stone {
	String color;
	double weight;
	String shape;
	double quantity;
	double price;
	
	public Stone(String color, double weight, String shape, double quantity, double price) {
		super();
		this.color = color;
		this.weight = weight;
		this.shape = shape;
		this.quantity = quantity;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Stone [color=" + color + ", weight=" + weight + ", shape=" + shape + ", quantity=" + quantity
				+ ", price=" + price + "]";
	}
	
	
	
	
}
