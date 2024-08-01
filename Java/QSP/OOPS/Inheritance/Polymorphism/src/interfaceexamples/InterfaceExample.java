package interfaceexamples;

@FunctionalInterface
interface Add {
	int addition(int num1, int num2) ; 
}


public class InterfaceExample {
	public static void main(String[] args) {
		
		Add obj = new Add() { // anonymous inner class 
			@Override
			public int addition (int num1, int num2) {
				return num1 + num2; 
			}
		}; // end of anon inner class 
		System.out.println(obj.addition(50, 50));
	}
	
}
