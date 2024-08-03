package objectClass;

public class CloneExample implements Cloneable {
	
	String s;

	CloneExample(String s) {
		this.s = s; 
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone(); 
	}

	public static void main(String[] args) throws CloneNotSupportedException {
		CloneExample t1 = new CloneExample("Java"); 
		CloneExample t2 = (CloneExample) t1.clone(); 
		System.out.println(t1);
		System.out.println(t2);

	}

}
