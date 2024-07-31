package abstratiaon;

abstract class Parent {
	abstract void loan(); 
}

class Child extends Parent {
	void loan() {
		System.out.println("Repaid the loan");
	}
}

public abstract class AbstratinoExample {
	
	abstract void addition();
	void substration() {
		System.out.println("some implementaoin");
	}
	
	
	public static void main(String[] args) {	
		Parent obj = new Child(); 
		obj.loan();
	}
}
