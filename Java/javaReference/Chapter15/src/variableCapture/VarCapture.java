package variableCapture;

// an example of capturing a local variable from the enclosing scope. 

interface MyFunc {
	int func(int n); 
}

public class VarCapture {

	public static void main(String[] args) {
		
		// A local variable that can be captured. 
		int num = 10; 
		
		MyFunc myLambda = (n) -> {
			// This use of num is Okay. It is not modify num. 
			int v = num + n; 
			
			// However, the following is illegal because it attempts 
			// to modify num. 
			// num++; 
			return v; 
			
		};
		
		// The following line would also cause an error, 
		// because it would remove the effectively final
		// status from num. 
		//num = 9; 

	}
}
