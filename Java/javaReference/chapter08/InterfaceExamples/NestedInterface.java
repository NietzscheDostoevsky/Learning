package InterfaceExamples;

// A nested interface example. 
class A {
	// this is a nested interface. 
	public interface NestedIF {
		boolean isNotNegative(int x); 
	}
}

class B implements A.NestedIF {
	@Override
	public boolean isNotNegative(int x) {
		return x < 0 ? false: true ;
	}
}


public class NestedInterface {

	public static void main(String[] args) {
		
		// use a nested interfece reference 
		A.NestedIF nIf = new B();
		
		if(nIf.isNotNegative(10))
			System.out.println("10 is not negative");
		if(nIf.isNotNegative(-12))
			System.out.println("This won't be displayed");

	}

}
