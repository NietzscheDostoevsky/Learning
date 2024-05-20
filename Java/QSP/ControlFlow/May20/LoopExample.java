class LoopExample{
	public static void main(String[] args) {
		
		// int i = 1;
		for(char ch = 48; ch<= 122; ch++){
			
			if((ch>=48&&ch<=55) || (ch>=65&&ch<=90) || (ch>=97&&ch<=122)){
			System.out.print(ch + " "); 

			 }
			
		}
		System.out.println(); 
		System.out.println("-----------------------------");
		for(char ch = 48; ch<= 122; ch++){
			
			if(!((ch>=58 && ch<=64) || (ch>=91 && ch<=96))){
			System.out.print(ch + " "); 
			 }
		}
		System.out.println(); 
		System.out.println("-----------------------------");
		for(char ch = 'A'; ch <='Z'; ch++){
			
			System.out.print(ch + " "); 
			ch++;ch++;
		}


	}
}