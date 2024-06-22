class Mobile {
	String brand; 
	String model; 

	Mobile(){
		System.out.println("Hi from no arg const()");

	}

	Mobile(int a){
		
	}

	public void displayMobile() {
		System.out.println("**MOBILE DETSILS");
		System.out.println("Brand: " + brand);
		System.out.println("Model : " + model);
	}

}

class MobileDriver {
	public static void main(String[] args) {
		Mobile obj = mobile.createMobile(); 
		obj.displayMobile();
	}
}