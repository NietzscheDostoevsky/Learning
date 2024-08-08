package genericFunctionalInterfaces;

// Use a generic functional interface with lambda expressions. 

// A generic functional interface. 

@FunctionalInterface
interface SomeFunc<T> {
	T func(T t); 
}

public class GenericFunctionalInterfaceDemo {

	public static void main(String[] args) {
		// Use a String-based version of SomeFunc. 
		SomeFunc<String> reverse = (str) -> {
			String result = ""; 
			int i; 
			for (i = str.length() -1; i>=0; i--)
				result += str.charAt(i); 
			return result;
		};
		
	}

}
