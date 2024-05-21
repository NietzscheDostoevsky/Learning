class SpecialASCIIChar {
	public static void main(String[] args) {
		
		for(char i = 0; i<=127; i++) {

			if( !((i>=48 && i<= 57) || 
				  (i>=65 && i<= 90) ||
				  (i>=97 && i<= 122))) {
				System.out.println("Special Character ASCII at index: " + (int)i + " : " + i )  ; 
			}
		}
	}
}