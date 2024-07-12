package SingleLevelInheritanceExample;

public class RedBull extends F1Car {
	
	String yearString; 
	String driver1;
	String driver2;
	String powerTrainString;
	
	//constructor
	RedBull(String brand, String model, int maxSpeed,
			double acceleration, 
			String y, String d1, String d2, String p){
		
		super(brand, model,maxSpeed,acceleration);
		this.yearString = y;
		this.driver1 = d1;
		this.driver2 = d2;
		this.powerTrainString = p;
		
	}
	
	public void displayRedBull() {
		super.displayDetails();
		System.out.println("Car Model Year" + this.yearString);
		System.out.println("Driver1" + this.driver1);
		System.out.println("Driver2" + this.driver2);
		System.out.println("Power Train supplier" + this.powerTrainString);
		
	}
	

}
