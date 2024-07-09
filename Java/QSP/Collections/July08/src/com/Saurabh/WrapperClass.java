package com.Saurabh;

public class WrapperClass {

	public static void main(String[] args) {
		 int a = 128;
		 Integer b = 128; 
		 
		 System.out.println(a == b );
		 
		 String c = "apple";
		 String d = "apple";
		 System.out.println(c == d);
		 
		 Test x = new Test();
		 Test y = new Test();
		 System.out.println(x == y);
		 
		 System.out.println((0.6 + 0.7) == (1.3));
		 
		 double g = 0.7 + 0.6 ; 
		 double h = 1.3 ; 
		 System.out.println(g == h);
		 
		 double i = 0.2 + 0.2 ; 
		 double j = 0.4 ;
		 System.out.println(i == j);
		 
		 
		 
		 
		 
		 
		
	}
}

class Test {
	
}