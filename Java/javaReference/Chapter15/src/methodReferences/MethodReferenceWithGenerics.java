package methodReferences;

// the fist parameter of the functional interface matches the invoking 
// 		object and the second parameter matches the parameter
//		specified by the method. 


//A functional interface that operates on an array and a value, and returns an int result. 
interface MyFunc1<T> {
	int func(T[]vals, T v);
}

// This class defines a method called countMatching() that returns 
// the number of items in an array that are equal to a specified value. 
// 		countMatching() is generic, but MyArrayOps is not. 

class MyArrayOps {
	static <T> int countMatching(T[] vals, T v) {
		int count = 0; 		
		for (int i = 0; i < vals.length; i++)
			if(vals[i] == v) count++; 
		return count; 
	}
}

public class MethodReferenceWithGenerics {
	
	static <T> int myOp(MyFunc1<T> f, T[] vals,  T v) {
		return f.func(vals, v);
	}
	
	public static void main(String[] args) {
		Integer[] integers = {  1, 2, 3, 4, 2, 3, 4, 4, 5 };
		String[] strings =  { "One", "Two", "Three", "Two" };
		int count; 
		
		count = myOp(MyArrayOps::<Integer>countMatching, integers, 4);
		System.out.println("count of 4: " + count);
		
		count = myOp(MyArrayOps::<String>countMatching, strings, "Two");
		System.out.println("count of 'two' : " + count);
	}

}
