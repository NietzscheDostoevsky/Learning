// Integer stack that can contains 10 values. 

class Stack {
	/*
	 * making stck and tos as private. This measns that
	 * they cannot be accidently or malicoiusly altered in a way taht
	 * would be harmful to the stack.
	 */
	// private means this code can only be accessed by the other members
	// of this class.
	private int[] stck = new int[10];
	private int tos; // top of stack

	// initialize top of stack
	Stack() {
		tos = -1;
	}

	// push an item into the stack
	void push(int item) {
		if (tos == 9) {
			System.out.println("Stack if full");
		} else {
			stck[++tos] = item;
		}
	}

	// pop an item from stack
	int pop() {
		if (tos < 0) {
			System.out.println("Stack underflow");
			return 0;
		} else {
			return stck[tos--];
		}
	}
}
