package variableShadowing;

public class Ramesh extends School {
	String name = "Ramesh"; 
	public static void main(String[] args) {
		Ramesh obj = new Ramesh(); 
		obj.home();
		System.out.println(obj);
	}
	 void schoolName() {
		System.out.println("HAHA school");
	}
	
	public void home() {
		String name = "Pappu"; // the local variable is shadowing the global one 
		System.out.println(this.name);
		System.out.println(name);
		System.out.println(super.name);
		System.out.println(this);
		//System.out.println(super); // CTE
		super.schoolName();
		schoolName();
	}

}

class School {
	String name = "Piyush";
	void schoolName() {
		System.out.println("XYZ school");
	}
	
}