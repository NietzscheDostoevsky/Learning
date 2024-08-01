package interfaceexamples;

interface Parent1 {
	String str = "Hello World";
}

interface Child extends Parent1 {
	String str = "HELLO JAVA";
	public static void m1() {
		System.out.println(str);
	}
}

public class MultipleInheritance {

	public static void main(String[] args) {
		Child.m1();
	}
}
