package reflection;

import java.lang.reflect.Constructor;
import java.util.Arrays;
public class ReflectionDemo1 {
	public static void main(String[] args) throws ClassNotFoundException {
		
		Class<?> c = Class.forName("java.awt.Dimension");
		System.out.println("Constructors");
		
		Constructor<?>[] constructors = c.getConstructors();
		System.out.println(constructors[1].getClass().getName());
		for (var i : constructors)
			System.out.println(i);
		
		System.out.println();
		System.out.println("Fields");
		Arrays.asList(c.getFields()).forEach(System.out::println);
		
		System.out.println();
		System.out.println("Methods");
		Arrays.asList(c.getMethods()).forEach(System.out::println);
		
		System.out.println("\n\n");
		c = Class.forName("java.lang.reflect.Constructor");
		System.out.println("Constructors");
		
		constructors = c.getConstructors();

		for (var i : constructors)
			System.out.println(i);
		
		System.out.println();
		System.out.println("Fields");
		Arrays.asList(c.getFields()).forEach(System.out::println);
		
		System.out.println();
		System.out.println("Methods");
		Arrays.asList(c.getMethods()).forEach(System.out::println);
	}
}
