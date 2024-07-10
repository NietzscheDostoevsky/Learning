package FishTank;

public class Fish {

	
	String species;
	String color;
	double price;
	
	public Fish(String species, String color, double price) {
		super();
		this.species = species;
		this.color = color;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Fish [species=" + species + ", color=" + color + ", price=" + price + "]";
	}
	
	
	
	
}
