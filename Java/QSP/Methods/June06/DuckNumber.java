class DuckNumber{
	public static void main(String[] args) {
		
		int num = 1203; 
		System.out.println(num);

		 boolean flag = false ; 

		 int i = num ; 
		 while(i!=0){
		 	int rem = i%10 ; 
		 	if(rem == 0) 
		 		flag = true ;
		 		break ; 
		 	i /= 10 ; 
		 }

		 if(flag){
		 	System.out.println("Duckkk");
		 }else{
		 	System.out.println("NOT a DUcky");
		 }
	}

}