package methodReferences;

// the fist parameter of the functional interface matches the invoking 
// 		object and the second parameter matches the parameter
//		specified by the method. 

interface myFunc<T> {
	int func(T[] vals, T v);
}

class MyArrayOps {
	static <T> int countMatching(T[] vals, T v) {
		int count = 0; 
		
		for (int i = 0; i < vals.length; i++)
			if(vals[i]== v) count++; 
		return count; 
	}
}

public class MethodReferenceWithGenerics {
	
	static <T> int myOp(MyFunc<T> f, T[] vals,  T v) {
		return f.func(vals, v)
	}

}
