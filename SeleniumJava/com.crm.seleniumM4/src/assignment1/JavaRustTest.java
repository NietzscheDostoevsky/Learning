package assignment1;

public class JavaRustTest {

	public static void main(String[] args) {
		
		int x = 32; 
		System.out.println("The value of x is : " + x);
		x = 55; 
		System.out.println("the new value if x is : " + x);
		final int b = x*x; // valid code in java 
		System.out.println(b);
		int y = 32; 
		
		{
			int y = y * 2; 
			System.out.println("Y in inner scope is : " + y);
		}
		
	}

}
