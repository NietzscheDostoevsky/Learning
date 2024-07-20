package VoidTest;

public class RecusiveConstructor {
	
	RecusiveConstructor(){
		
		System.out.println("HELLO");
		RecusiveConstructor obj = new RecusiveConstructor();
		
	}
	
	
	public static void main(String[] args) {
		
		RecusiveConstructor obj1 = new RecusiveConstructor(); 	
	}

}


