package objectClass;

public class TestGC {
	String s; 
	TestGC(String s) {
		this.s = s; 
	}
	
	@Override
	protected void finalize() {
		System.out.println("HAHA, GC invoked");
	}
	
	public static void main(String[] args) {
		TestGC t = new TestGC("Java");
		
		System.out.println(t.s);
		t=null; 
		System.gc();
		
	}
}
