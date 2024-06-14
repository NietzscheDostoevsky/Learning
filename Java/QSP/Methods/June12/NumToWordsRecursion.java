class NumToWordsRecursion{

	public static void main(String[] args) {
		
		int num = 123237493 ;
		String op = "" ; 

		while(num != 0){

			int rem = num % 10 ; 
			// System.out.println(rem);

			switch(rem){
				case 0: op = "Zero " +  op; break; 
				case 1: op = "One " + op; break; 
				case 2: op = "Two " + op; break; 
				case 3: op = "Three " + op; break; 
				case 4: op = "Four " + op; break; 
				case 5: op = "Five " + op; break; 
				case 6: op = "Six "+ op; break; 
				case 7: op = "Seven " + op; break; 
				case 8: op = "Eight " + op; break;  
				case 9: op = "Nine "+ op; break; 

			}

			num /= 10 ;
		}

		System.out.println(op);
	}
}