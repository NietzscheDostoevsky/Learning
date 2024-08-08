class TryCatchExample {
	public static void main(String[] args) {
		System.out.println("Hello");
		System.out.println("Hii");
		try {
			System.out.println(10/0);
			} 
		catch(Exception e) {
			System.out.println("Exception has been handled");
			}
		System.out.println("Byee");
		System.out.println("Hello");
		System.out.println("Hello");

		Object str = new String("Hellloo");
		try {
			StringBuffer sb = (StringBuffer)str; 
		}
		catch(ClassCastException cce) {
			System.out.println("h");
		}
		System.out.println("Byeeee");

		try {
		Thread.sleep(1000);
		}
		catch(ArithmeticException ae) {
			System.out.println("AE");
		}
		catch(RuntimeException re) {
			System.out.println("RE");
		}


		}

}