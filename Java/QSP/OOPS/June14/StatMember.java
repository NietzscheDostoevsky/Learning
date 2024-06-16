
class StatMember{

	public static void main(String[] args) {
		
		int add = ArithmaticOperation.addition(10, 30);
		System.out.println(add);

	}
}

class ArithmaticOperation{

	public static int addition(int num1, int num2){
		return num1 + num2;
	}

	public static int substraction(int num1, int num2){
		return num1 - num2 ; 
	}

	public static int multiplicatiion(int num1, int num2){
		return num1 * num2 ; 
	}
}