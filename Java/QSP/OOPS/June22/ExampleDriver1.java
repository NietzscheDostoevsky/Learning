class Parent {

	super() ; // invokes object classs const 
	Parent() {
		System.out.println(" no args const of parent class");
	}
}

class Child extends Parent{
	Child(){
		super();
		System.out.println("No args const of child class");
	}
}

class ExampleDriver1 {
	public static void main(String[] args) {
		
		Child obj = new Child();
	}
}
