package simpleGenericExample;

public class NonGenDemo {

	public static void main(String[] args) {
		
		NonGen iOb; 
		
		iOb = new NonGen(73); 
		iOb.showType(); 
		
		int v = (Integer) iOb.getObject();
		System.out.println("Value: " + v);
		
		System.out.println();
		
		NonGen strOb = new NonGen("NOn_Generic Test" ); 
		strOb.showType();
		
		String str = (String) strOb.getObject();
		System.out.println("Value : " + str);
		
		iOb = strOb; 
		v = (Integer) iOb.getObject(); // runtime error
									   // class cast exception .
		
	}

}
