package interfaceexamples;

public interface Addition1 {
	int addition(int num1, int num2); 

}

class Calculator implements Addition1 {
	@Override
	public int addition(int num1, int num2) {
		return num1 + num2; 
	}
}

class Addition {
	public static void main(String[] args) {
		
	}
}
