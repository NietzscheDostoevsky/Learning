package genericMethod;

// demonstrate a simple generic method 

public class GenMathDemo {

	// Determine if an objectg is in array.

	public static <T extends Comparable<T>, V extends T> boolean isIn(T x, V[] y) {
			
		for (int i = 0; i < y.length; i++) {
			if(x.equals(y[i])) {
				return true;
			}
		}
		return false;
	}

}
