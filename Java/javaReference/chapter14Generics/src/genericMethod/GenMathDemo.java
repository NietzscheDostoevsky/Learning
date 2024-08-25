package genericMethod;

// demonstrate a simple generic method 

public class GenMathDemo {

	// Determine if an object is in array.
	static <Key extends Comparable<Key>, Value extends Key> boolean isIn(Key x, Value[] y) {
		for (int i = 0; i < y.length; i++) 
			if(x.equals(y[i])) 
				return true;
		return false;
	}
}
