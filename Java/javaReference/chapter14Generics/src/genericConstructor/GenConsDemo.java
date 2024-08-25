package genericConstructor;

class GenCons {
	private double val;
	
	<Type extends Number> GenCons(Type arg) {
		val = arg.doubleValue();
	}
	
	void showVal() {
		System.out.println("val: " + val);
	}
}

public class GenConsDemo {
	public static void main(String[] args) {
		GenCons testCons = new GenCons(100);
		GenCons testCons2 = new GenCons(123.5f);
		
		testCons.showVal();
		testCons2.showVal();
	}
}