class StaticDemo {
	static {
		//m2();
	}

	public static void m1(){
		//m2();
	}

	public void m2(){

	}
}

class StaticDemoDriver {
	public static void main(String[] args) {
		StaticDemo ob = new StaticDemo();
		ob.m2();
		StaticDemo.m1();
		StaticDemo.m2();
	}
}