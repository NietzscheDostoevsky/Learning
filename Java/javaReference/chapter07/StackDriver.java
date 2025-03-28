// Improved Stack class that uses the length array number

class Stack {
	private int[] stck; 
	private int tos;

	// allocating and initialize stack
	Stack(int size) {
		stck = new int[size];
		tos = -1;  
	}

	// push an item into the stack
	void push(int item) {
		if(tos == stck.length-1){
			System.out.println("Stack is full");
		} else {
			stck[++tos] = item;
		}
	}
		// pop item from the stack 
	int pop() {
		if(tos < 0) {
			System.out.println("Stack underflow");
			return 0;
		} else {
			return stck[tos--];
		}
	}	
}

class StackDriver {
	public static void main(String[] args) {
		Stack myStack1 = new Stack(5); // calling Stack initializer with initial value
		Stack myStack2 = new Stack(8); 

		// pushing some data into the stack
		for(int i=0; i<8; i++) myStack1.push(i);
		for(int i=0; i<8; i++) myStack2.push(i);

		// pop these numbers off the stack
		System.out.println("Stack in myStack1: ");
		for(int i=0; i<5; i++)
			System.out.println(myStack1.pop());
		for(int i=0; i<8; i++)
			System.out.println(myStack2.pop());
	}
}