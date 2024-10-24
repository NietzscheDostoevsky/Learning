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
		
		System.out.println(String.format("Lambda reversed is: %s", reverse.func("Lambda")));
		System.out.println(String.format("Expression reversed is: %s", reverse.func("Expression")));
		
		// NOw using integer based implementation of SomeFunc
		
		SomeFunc<Integer> factorial = (n) -> {
			int result = 1; 
			for (int i = 1; i <=n; i++) {
				result = i * result; 
			}
			return result; 
		};
		
		System.out.println("The factoral of 3 is " + factorial.func(3));
		System.out.println("The factoral of 5 is " + factorial.func(5));
	}

}
