package InterfaceExamples;

public class FixedStackDriver {

	public static void main(String[] args) {
		
		FixedStack myStack1 = new FixedStack(5); 
		FixedStack myStack2 = new FixedStack(8); 
		
		// pushing numbers into the stack 
		
		for(int i=0; i<5; i++) myStack1.push(i);
		for(int i=0; i<8; i++) myStack2.push(i);
		
		// pop and print 
		for(int i=0; i<5; i++) 
			System.out.print(myStack1.pop() + " ");
		System.out.println();
		for(int i=0; i<8; i++) 
			System.out.print(myStack2.pop() + " ");

	}

}
