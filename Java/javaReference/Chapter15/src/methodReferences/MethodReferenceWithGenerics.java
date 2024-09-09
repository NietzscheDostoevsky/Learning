package methodReferences;

// the fist parameter of the functional interface matches the invoking 
// 		object and the second parameter matches the parameter
//		specified by the method. 


//A functional interface that operates on an array and a value, and returns an int result. 
interface MyFunc1<T> {
	int func(T[]vals, T v);
}

// This class defines a method called countMatchin() that returns 
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

}
