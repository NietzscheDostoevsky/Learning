class Exc2 {
	public static void main(String[] args) {
		
		int d, a; 

		try { // monitoring this block of code
			d = 0; 
			a = 42/d; // this would throw an / by 0 exception

			System.out.println("This like should not be printed");
		} catch (ArithmeticException e) { // catch divide-by-zero error
			System.out.println("Division by Zero");
		}
		System.out.println("Statement after Catch block");
	}
}