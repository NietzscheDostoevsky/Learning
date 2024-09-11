package constructorReferences;


//MyFunc is a functional interface whose method returns a MyClass reference. 
interface MyFunc {
	MyClass func(int n); 
}

class MyClass {
	private int val; 
	MyClass(int val) { this.val = val;}
	MyClass() {this.val = 0;}
	int getVal() {return this.val;}
}


public class ConstructorRefDemo {

	public static void main(String[] args) {
		
		//Creating a reference to the MyClass constructor.
		//Because func() in MyFunc takes an argument. 
		// new refers to the parameterized constructor in MyClass, 
		// not the default constructor. 
		
		MyFunc myClassCons = MyClass::new ;
		
		// Create an instance of MyClass via that constructor reference. 
		MyClass mc = myClassCons.func(100);
		System.out.println(mc.getVal());
		
		// MyClass mc2 = myClassCons.func(); // CTE because func(int n) binds to MyClass(int n)
		
	}

}
