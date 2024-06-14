class Recursion{

	static int i = 1 ; 

	public static void main(String[] args) {

		System.out.println("Hello from Main");
		m1(); 
		
	}

	public static void m1() {
		System.out.print(i++ + " ");
		if(i++ ==100) return ; 
		m1(); 

	}
}