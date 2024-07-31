package methodOverriding;

class Father {
	void carrer() {
		System.out.println("Classical Singer");
	}
}

class ChildRamesh extends Father {
	public void carrer() {
		System.out.println("Pop Singer");
	}
}

class ChildSuresh extends Father {
	
}

public class OverridingExample2 {
	public static void main(String[] args) {
		Father obj1 = new ChildRamesh(); 
		//obj1 = (ChildRamesh) obj1;
		obj1.carrer(); 
		
		Father obj2 = new ChildSuresh(); 
		obj2.carrer();
		
		ChildRamesh obj3 = new ChildRamesh(); 
		obj3.carrer();
	}
}
