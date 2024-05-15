class Marriage{
	public static void main(String[] args) {
		int age = 22 ;
		int money = 2_000_000_000 ; 
		String surname = "Adani" ; 

		if((age > 21) && (money > 1_00_00_000) && (surname == "Ambani") ){
			System.out.println("Elegible") ;
		}else{
			System.out.println("Not Eligible");
		}
	}
}