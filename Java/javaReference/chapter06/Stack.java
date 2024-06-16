// This class defines an interger stakck that can hold 10 values. 

class Stack {
	int[] stck = new int[10]; 
	int tos; 

	// Initiazlizing top of the stack 
	Stack() { // stack constructor 
		tos = -1 ; // ++tos would start with 0 
	}

	// Pushing an intem into the stack 
	void push(int item) {
		if(tos == 9) {
			System.out.println("Stack is full.");
		} 
		else {
			stck[++tos] = item; 
		}
	}

	// Pop an item from stack 
	int pop() {
		if(tos < 0) {
			System.out.println("Stack underflow");
			return 0;
		}
		else {
			return stck[tos--];
		}
	}
}