package twoTypeParametersExample;

public class DemoTwoGen {

	public static void main(String[] args) {
		
		TwoGen<Integer, String> obj = 
				new TwoGen<Integer, String>(73, "Generics");
		
		obj.showTypes();
		
		// Obtain and show values.
		int v = obj.getOb1();
		System.out.println("value: " + v);
		String str = obj.getOb2();
		System.out.println("value: " + str);

	}

}
