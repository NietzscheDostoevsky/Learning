// find factors of a number using recursion 

class FactorsRecursion{

	public static void factors(int num, int current){
		if(current > num) return ; 
		if(num % current == 0)
			System.out.println(current);
		factors(num, current+1); 
	}

	public static void main(String[] args) {
		int num = 45 ;
		factors(num, 1);
	}


}


