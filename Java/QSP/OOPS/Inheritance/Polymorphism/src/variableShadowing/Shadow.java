package variableShadowing;

public class Shadow {
	public static void main(String[] args) {
		
		Parent obj = new Child();
		System.out.println(obj.getClass().getName());
		System.out.println(obj.str);
		System.out.println(obj.super.str);
		
		obj = (Child)obj;
		System.out.println(obj.getClass().getName());
		System.out.println(obj.str);
	}
}

class Parent {
	String str = "Parent";
}

class Child extends Parent {
	String str = "Child"; 
}
