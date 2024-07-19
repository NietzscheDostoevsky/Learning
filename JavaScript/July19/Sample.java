 class RecusiveConstructor {
	
	RecusiveConstructor(){
		System.out.println("HELLO");
		try{
			RecusiveConstructor obj = new RecusiveConstructor();
		}catch(StackOverflowError i){
			System.out.println("EXECUTION STOPS haha ");
		}
	}
	public static void main(String[] args) {
		RecusiveConstructor obj1 = new RecusiveConstructor(); 	
	}

}


