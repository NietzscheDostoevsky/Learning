// Demostrate Method Overloading 

class OverloadDemo {
	void test() {
		System.out.println("No Parameters");
	}

	// Overloading test for one integer parameter
	void test(int a) {
		System.out.println("a: " + a);
	} 

	// olverload rind  test for dwo ineger para
	void test(int a, int b) {
		System.out.println("a and b: " + a + " " + b);
	}

	// olverloafding for a double parametenr 
	double test(double a) {
		System.out.println("double a: " + a);
		return a * a ; 
	}
}

class Overload {
	public static void main(String[] args) {
		OverloadDemo ob = new OverloadDemo(); 
		double result;

		// calling all versions of test() 
		ob.test();
		ob.test(10);
		ob.test(10, 20);
		result = ob.test(137.37);
		System.out.println(result);

	}

}