package FishTank;

public class Water {
	
	String type;
	double pH; 
	double quantity;
	
	public Water(String type, double pH, double quantity) {
		super();
		this.type = type;
		this.pH = pH;
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Water [type=" + type + ", pH=" + pH + ", quantity=" + quantity + "]";
	} 
	
	
}
