class Demo {
	
	private double balance = 2_000; 
	private int PIN = 123;
	public double getBalance(int PIN1){
		if(PIN1 == PIN){
			return balance;
		} else {
			return 0.0;
		}
	}

}

class Driver1 {
	public static void main(String[] args) {
		
		Demo obj = new Demo();
		System.out.println(obj.getBalance(1234));
	}
}