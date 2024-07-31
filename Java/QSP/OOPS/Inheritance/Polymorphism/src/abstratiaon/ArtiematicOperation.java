package abstratiaon;

abstract public class ArtiematicOperation {
	public abstract int addition( int num1, int num2);
	public abstract int substraction(int num1, int num2); 
	public abstract int multiplication(int num1, int num2); 
	public abstract int division(int num1, int num2); 
	
}

abstract class  Calculator extends ArtiematicOperation {

	public int addition(int num1, int num2) {		
		return num1 + num2;
	}
	public int substraction(int num1, int num2) {		
		return num1 - num2;
	}
	
	
}

class Calci extends Calculator {

	public int multiplication(int num1, int num2) {		
		return num1 * num2;
	}
	public int division(int num1, int num2) {		
		return num1 / num2;
	}
	
	
}

