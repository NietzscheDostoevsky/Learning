// showing stack tree of the error. 

class Exc1 {
	static void subroutine() {
		int d = 0; 
		int a = 10/d; // divide by 0 error 
	}

	public static void main(String[] args) {
		Exc1.subroutine();
		// will builld successfully, but there would be an Arithmatic Exception . 
	}
}