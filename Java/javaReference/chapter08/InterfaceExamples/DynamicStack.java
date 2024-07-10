package InterfaceExamples;

public class DynamicStack implements IntStack {
	
	// implements a growable dynamic stack 
	
	private int[] stck ; 
	private int tos; 
	
	// allocationg and initilzing stack 
	public DynamicStack(int size) {
		this.stck = new int[size]; 
		this.tos = -1;
	}
	
	// pushing an item into stack 
	@Override
	public void push(int item) {
		// if stack is full, allocate a larger stack 
		if(tos==stck.length-1) {
			int[] temp = new int[stck.length * 2]; // doubling size 
			for(int i=0; i<stck.length; i++) temp[i] = stck[i];
			stck = temp; 
			stck[++tos]= item; 
		} else {
			stck[++tos] = item; 
		}
	}
	
	// pop an item and return 
	@Override
	public int pop() {
		if(tos < 0) {
			System.out.println("Stack Underflow");
			return 0; 
		} else {
			return stck[tos--]; 
		}
	}

}
