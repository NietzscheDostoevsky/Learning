package InterfaceExamples;

// Demonstrating how a interface varialbe can be used to 
// refer to differnet classes that implements it 
// dynamically at runtime


public class FixedDynamicStackdriver {

	public static void main(String[] args) {
		
		IntStack myStack ; // creating an interface reference varialble ;
		DynamicStack dStack = new DynamicStack(5); 
		FixedStack fStack = new FixedStack(8); 
		
		myStack = dStack; // assigning dynamic stack 
		
		// pushing numbers into stack 
		for(int i=0; i<12; i++) {
			myStack.push(i);// dynamic method dispatch. 
							// which implementation of push is to be used is 
							// decided at the runtime, rather than compiletime. 
			
		}
		myStack = fStack; // change to fixed stack now 
		for(int i=0; i<8; i++) myStack.push(i);
		
		myStack = dStack; 
		System.out.println("Values in dynamic stack");
		for(int i=0; i<12; i++)
			System.out.println(myStack.pop());
		
		myStack = fStack; 
		System.out.println("Values in fixed stack");
		for(int i=0; i<8; i++) {
			System.out.println(myStack.pop());
		}

	}

}
