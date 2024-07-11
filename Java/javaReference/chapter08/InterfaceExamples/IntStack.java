package InterfaceExamples;

public interface IntStack {
	public void push(int item); // store an item 
	public int pop(); // retreive an item
	
	// providing a default clear() method for the stack interface
	// without breaking the code
	
	default void clear() {
		System.out.println("Clear is NOT implemented. ");
	}
	
}
