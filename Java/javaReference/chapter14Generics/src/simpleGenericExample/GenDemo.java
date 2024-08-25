package simpleGenericExample;

public class GenDemo {
	
	public static void main(String[] args) {
		
		// Create a generic reference for Integers. 
		
		Gen<Integer> iOb; 
		
		iOb = new Gen<Integer>(73) ; 
		iOb.showType();
		
		var v = iOb.getObj();
		System.out.println("value: " + v);
		
		System.out.println();
		
		// creating a generic reference for strings ;
		
		Gen<String> strOb = new Gen<String>("Generic Test");
		strOb.showType();
		
		var s = strOb.getObj(); 
		System.out.println("Value: " + s);
	}
}