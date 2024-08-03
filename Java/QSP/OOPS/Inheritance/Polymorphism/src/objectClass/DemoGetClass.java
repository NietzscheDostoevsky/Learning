package objectClass;

import java.util.Scanner;

public class DemoGetClass {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DemoGetClass d = new DemoGetClass(); 
		System.out.println(sc.getClass());
		System.out.println(d.getClass());
		System.out.println(sc.getClass().getName());
		System.out.println(d.getClass().getName());
		

	}

}
