class TestStack {
    // to test the stack class
    public static void main(String[] args) {
        Stack myStack1 = new Stack();
        Stack myStack2 = new Stack();

        // pushing some numbers into the stack

        for (int i = 0; i < 10; i++) {
            myStack1.push(i);
        }
        for (int i = 10; i < 20; i++) {
            myStack2.push(i);
        }

        // pop numbers out of stack and print
        System.out.println("Stack inside myStack1");
        for (int i = 0; i < 10; i++) {
            System.out.println(myStack1.pop());
        }
        System.out.println("Stack inside myStack2");
        for (int i = 0; i < 10; i++) {
            System.out.println(myStack2.pop());
        }

    }
}