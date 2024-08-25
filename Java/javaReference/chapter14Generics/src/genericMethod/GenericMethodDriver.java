package genericMethod;

import static genericMethod.GenMathDemo.isIn;

public class GenericMethodDriver {

	public static void main(String[] args) {
		// Use isIn() on integers.
		Integer[] numsIntegers = { 1, 2, 3, 4, 5 };
		if (isIn(2, numsIntegers)) {
			System.out.println("2 is in nums");
		}
		if (!isIn(7, numsIntegers)) {
			System.out.println("7 is not in nums ");
		}

		// Use isIn() on Strings.
		String[] strs = { "one", "two", "three", "four", "five" };
		if (isIn("two", strs))
			System.out.println("two is in strs");
		
		if (!isIn("seven", strs))
			System.out.println("seven is not in strs");
		
		// Oops! Won't compile! Types must be compatible.
//		if (isIn("two", nums))
//			System.out.println("two is in strs");

	}
}
