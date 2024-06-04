class MethodExample2{

	static int count = 1 ; 
	public static void main(String[] args) {
		
		m1();
		m1();


	}

	public	static void m1(){
		System.out.println("Hello M1" + count++);
		m1();
		

	}

	
}