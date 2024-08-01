package interfaceexamples;
interface ParentA {
	default void greeting() {
		System.out.println("HEHE");
	}
}
interface ParentAA {
	default void greeting() {
		System.out.println("HAHA");
	}
}

interface ChildA extends ParentA, ParentAA {
	
}

public class Example2 {

}
