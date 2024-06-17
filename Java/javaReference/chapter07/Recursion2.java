// example to show recursion. 
// prints first i elements in the array values 

class RecTest {
	int[] values; 

	RecTest(int i) {
		// class constructor 
		this.values = new int[i]; 
	}

	// displaying array recursively 
	String printArray(int i) {
		if(i == 0) {
			return "haha"; 
		}
		else {
			String a = printArray(i-1);
			System.out.println(a);

		}
		System.out.println("[" + (i-1) + "] " + values[i-1]);
		return "kiki" ;
	}

}

class Recursion2 {
	public static void main(String[] args) {
		RecTest ob = new RecTest(3); 
		int i ; 

		for(i=0; i<3; i++) {
			ob.values[i] = i; 
		}
		ob.printArray(3); 
	}
}