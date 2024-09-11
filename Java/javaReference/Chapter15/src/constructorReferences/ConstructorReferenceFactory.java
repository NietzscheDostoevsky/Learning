package constructorReferences;

// Implementing a simple class factory using a constructor reference. 

//T is type of parameter to constructor
//R is type of object being created. 
interface MyFuncFactory<R, T> {
	R func(T n);
}

// An array creator. 
interface MyArrayCreator<T> {
	T func(int n);
}

//A simple generic class. 
class MyClass1<T> {
	private T valT; 
	MyClass1(T v) {this.valT = v;}
	public MyClass1() {this.valT = null;}
	T getVal() { return valT;}
}

// A simple Non-Generic Class. 
class MyClass3 {
	
	String string; 
	MyClass3(String s){this.string = s;}
	MyClass3() { this.string = "";}
	String getVal() { return this.string;}
}

public class ConstructorReferenceFactory {
	
	//A factory method for class objects. The class must have a constructor
	//that takes one parameter of type T. 
	//R specifies the type of Object being created. 
	//This method is being passed a constructor for the object its building.
	static <R,T> R myClassFactory(MyFuncFactory<R,T> cons, T v) {
		return cons.func(v);
	}
	
	
	public static void main(String[] args) {
		
		//MyFuncFactory<MyClass1<Double>, Double> myClassCons = MyClass1<Double>::new;
		
		//create an instance of MyClass1 by use of the factory method. 
		MyClass1<Double> mc = myClassFactory(MyClass1<Double>::new, 100.1);
		
		//Now create a different class by use of myClassFactory()
		MyFuncFactory<MyClass3, String> myClassCons2 = MyClass3::new;
		MyClass3 mc2 = myClassFactory(myClassCons2, "Lambda");
		
		System.out.println(mc.getVal());
		System.out.println(mc2.getVal());
		
		MyArrayCreator<MyClass[]> mcArrayCons = MyClass[]::new;
		MyClass[] a = mcArrayCons.func(2);
		

	}

}
