package FishTank;

public class Tank {
	
	
	String dimensions;
	String material; 
	String shape;
	double capacity;
	
	public Tank(String dimensions, String material, String shape, double capacity) {
		super();
		this.dimensions = dimensions;
		this.material = material;
		this.shape = shape;
		this.capacity = capacity;
	}
	
	@Override
	public String toString() {
		return "Tank [dimensions=" + dimensions + ", material=" + material + ", shape=" + shape + ", capacity="
				+ capacity + "]";
	}
	
}

	
