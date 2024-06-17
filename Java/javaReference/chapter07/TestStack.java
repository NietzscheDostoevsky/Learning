class TestStack {
	public static void main(String[] args) {
		Stack myStack1 = new Stack(); 
		Stack myStack2 = new Stack(); 

		// push some nums into the stack 
		for(int i=0; i<10; i++) myStack1.push(i); 
		for(int i=10; i<20; i++) myStack2.push(i);

		// pop those members and print 
		System.out.println("Stack in myStack1");
		for(int i=0; i<10;i++){
			System.out.println(myStack1.pop());
		}
		System.out.println("Stack in MyStack2");
		for(int i=0; i<10; i++){
			System.out.println(myStack2.pop());
		}

		// illegal statements since class vars in stack are marked private
		// myStack1.tos = -2; 
		// myStack2.stck[2] = 100 ;
	}
}