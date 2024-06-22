class Parent {

	
	Parent() {
		super() ; // invokes object classs const 
		System.out.println(" no args const of parent class");
	}

	Parent(int a ) {
		this();
		System.out.println( "int arg const of parent class");
	}
}

class Child extends Parent{
	Child(){
		
		this((byte)10);
		System.out.println("No args const of child class");
	}

	Child(byte a){
		super(a);
		System.out.println("Byte argument const ");
	}

}

class ExampleDriver1 {
	public static void main(String[] args) {
		
		Child obj = new Child();
	}
}
