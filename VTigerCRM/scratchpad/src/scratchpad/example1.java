package scratchpad;

public class example1 {

	public static void main(String[] args) {
		String str = "Hello World";

		for (char c : str.toUpperCase().toCharArray()) {

//			System.out.println(c);
//			System.out.println((int)c);	
			System.out.println(c);
			System.out.println(Character.isUpperCase(c));
		}
	}
}
