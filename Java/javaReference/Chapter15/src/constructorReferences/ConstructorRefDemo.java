package constructorReferences;

//Modified to use generic syntax. 

//MyFunc is a functional interface whose method returns a MyClass reference. 
interface MyFunc<T> {
	MyClass<T> func(T n); 
}

class MyClass<T> {
	private T val; 
	MyClass(T val) { this.val = val;}
	MyClass() {this.val = null;}
	T getVal() {return this.val;}
}


public class ConstructorRefDemo {

	public static void main(String[] args) {
		
		//Creating a reference to the MyClass constructor.
		//Because func() in MyFunc takes an argument. 
		// new refers to the parameterized constructor in MyClass, 
		// not the default constructor. 
		
		MyFunc<Integer> myClassCons = MyClass<Integer>::new ;
		
		// Create an instance of MyClass via that constructor reference. 
		MyClass<Integer> mc = myClassCons.func(100);
		System.out.println(mc.getVal());
		
		// MyClass mc2 = myClassCons.func(); // CTE because func(int n) binds to MyClass(int n)
		
		MyFunc<String> myClassCons3 = MyClass<String>::new;  
		MyClass<String> mc3 = myClassCons3.func("Haha");
		System.out.println(mc3.getVal());
	}

}
