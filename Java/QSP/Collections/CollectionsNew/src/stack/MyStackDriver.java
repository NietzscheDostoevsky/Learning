package stack;

public class MyStackDriver {
	public static void main(String[] args) {
		MyStack<String> stack = new MyStack<>();
		stack.push("1");
		stack.push("2");
		stack.push("3");
		stack.push("4");
		System.out.println(stack.pop());
		System.out.println(stack.peek());
		System.out.println(stack);
		
	}

}
