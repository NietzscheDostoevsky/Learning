class MultiplicationCheck{
	public static void main(String[] args) {
		
		int num = 1 ; 
		int prod = 1;
		for(int i = 1; i<45; i++){
			num = prod ; 
			prod = prod * i ; 
			System.out.println(num + " * " + i + " = " + prod);
			
		}

		int num2 = 1 ; 
		int prod2 = 1;
		for(int i = 1; i<90; i++){
			num2 = prod2 ; 
			prod2 = prod2 * i ; 
			System.out.println(num2 + " * " + i + " = " + prod2);
			i++;
		}
	}
}