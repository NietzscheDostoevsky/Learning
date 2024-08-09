class ExceptionDemo2 {
	public static void main(String[] args) {
		try{
			System.out.println("Outer try");
			try {
				System.out.println("intner try");
				System.out.println(10/0);
			} catch (NullPointerException npe){
				System.out.println("Inner catch");
				String str = null; 
				str.charAt(0); 
			}
		} catch (NullPointerException npe) {
			System.out.println("Outer catch NPE");
		} catch (ArithmeticException ae) {
			System.out.println("Oouter catch ae");
		}

	}
}