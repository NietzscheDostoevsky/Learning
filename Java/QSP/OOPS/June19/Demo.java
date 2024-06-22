class Demo1 {

	static{
		System.out.println("SB from demo 1");
	}


	
	public static void main(String[] args) {

		Demo2 obj = new Demo2();
		Demo2 obj2 = new Demo2(); 

	}

}

class Demo2 {
	static{
		System.out.println("SB from demo 2");
	}
	{
		System.out.println("nsb from demo 2");
	}
	void m1(){
		System.out.println("m1 from demo2");
	}
}