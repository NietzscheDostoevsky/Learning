package InterfaceExamples;

public interface IntStack {
	public void push(int item); // store an item

	public int pop(); // retreive an item

	// providing a default clear() method for the stack interface
	// without breaking the code

	default void clear() {
		System.out.println("Clear is NOT implemented. ");
	}

	default int[] popNElements(int n) {
		// Return the requested elements.
		return getElements(n);
	}

	// A default method that returns an array that contains
	// the next n elements on the stack after skipping elements.
	default int[] skipAndPopNElements(int skip, int n) {
		// Skip the specified number of elements.
		getElements(skip);
		// Return the requested elements.
		return getElements(n);
	}

	// A private method that returns an array containing
	// the top n elements on the stack
	private int[] getElements(int n) {
		int[] elements = new int[n];
		for (int i = 0; i < n; i++)
			elements[i] = pop();
		return elements;
	}

}
