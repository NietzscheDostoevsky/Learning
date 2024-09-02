package textBlocks;

public class Indentatoin {

	public static void main(String[] args) {
		String str = """
				A
					B
				C
		"""; // this will determine the start of indent
		
		String str2 = """
				A
					B
				C
				"""; // this has no effect
		
		String str3 = """
				A
					B
				C
			"""; // this removes whitespace up to the """
		
		System.out.print(str);
		System.out.print(str2);
		System.out.print(str3);
		
		String string = """
				this is a "test"
				""";
		System.out.println(string);
	}

} 
