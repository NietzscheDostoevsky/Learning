package FishTank;

public class Tank {
	
	
	String dimensions;
	String material; 
	String shape;
	double capacity;
	Fish fish; 
	Water water;
	Stone stone; 
	FishFood fishFood;
	Light light; 
	
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
	
	public void addWater() {
		water = new Water("Salt", 7, 9);
		System.out.println("Water Added");				
	}
	
	public void addFish() {
		if(water == null) {
			System.out.println("Add water first");
		} else {
			this.fish = new Fish("Shark", "Black", 50.0);
		}		
	}
	
	public void addStone() {
		
		stone = new Stone("rainbow", 12.0, "oval", 10, 500);
	}
	
	public void addFishFood() {
		fishFood = new FishFood("Kellogs",500,10.0);
	}
	public void addLight() {
		light = new Light("PHilips", "blue", 4.5, 100);
	}
}

	
