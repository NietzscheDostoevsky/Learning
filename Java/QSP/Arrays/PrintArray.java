public class PrintArray {

	// generic class to print arrays 
	 public static <T> void printArray(T[] array) {

	 	for (T element : array) {
	 		System.out.print(element + " ");
	 	}
	 	System.out.println();
	 }
}

class PrintArrayDriver {
	public static void main(String[] args) {
		
		Integer[] intArray = {1,2,3,4,5,6};
		String[] stringArray = {"A", "B", "C"};

		PrintArray.printArray(intArray);
		PrintArray.printArray(stringArray);
	}
}