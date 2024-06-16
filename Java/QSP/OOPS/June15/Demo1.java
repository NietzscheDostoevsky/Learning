class Demo1{

	static int a = Demo3.m1() ;

	static{

		System.out.println("SB1 from Demo1 ");
	}

	public static void main(String[] args) {
		System.out.println("Hello main()");
		
	}
}

class Demo3{
	static{
		System.out.println("SB from Demo3");
	}
	public static int m1(){
		System.out.println("Hie m1() from demo3");
		return 100 ; 
	}
}