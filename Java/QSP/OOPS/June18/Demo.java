class Demo {
	public static void main(String[] args) {
		
		System.out.println("Hello main()");
		Demo obj = new Demo();
		obj.m1();
		obj.m2(); 
	}
	public void m1(){
		System.out.println("Hello from m1()");
		m2();
	}
	public void m2(){
		System.out.println("Hello from m2()");
		m3();
	}

	public static void m3(){
		System.out.println("Hey from m3()");
	}
}