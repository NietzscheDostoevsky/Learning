class ExceptionDemo {
	public static void main(String[] args) {
		
		System.out.println("Hello from mian()");
		m1(); 
		System.out.println("Byeee from main()");
	}

	static void m1() {
		System.out.println("Hello from m1()");
		m2(); 
		System.out.println(10/0);
	}

	static void m2() {
		System.out.println("Hello from m2()");
		System.out.println("Byee from m2()");
	}
}