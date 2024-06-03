class MethodExample{
	public static void main(String[] args) {
		
		System.out.println("Hello from main() method");
		myMethod();
		addition(21, 35); 
	}

	public static void myMethod(){
		System.out.println("Hhii fro My methodd");

		
	}

	public static int addition(int num1, int num2){
		int sum = 0 ; 
		sum = num1 + num2 ; 
		return sum ;
	}
}