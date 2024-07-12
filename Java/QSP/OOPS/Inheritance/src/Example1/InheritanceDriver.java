package Example1;

class Ramesh {
	String str1 = "PAREBT CLASS"; 
	void parentMethod() {
		System.out.println("Hello from parent method");
	}
	
}

class Suresh extends Ramesh {
	String str2 = "CHILD CLASS";
	void childMethod() {
		System.out.println("HELLO FROM CHILD CLASSS");
	}
			
}


public class InheritanceDriver {
	public static void main(String[] args) {
		
		Suresh objSuresh = new Suresh();
		System.out.println(objSuresh.str1);
		System.out.println(objSuresh.str2);
		objSuresh.parentMethod();
		objSuresh.childMethod();
		
	}

}
