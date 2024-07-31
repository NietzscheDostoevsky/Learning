package VoidTest;

public class RecusiveConstructor {

    RecusiveConstructor() {
        try {
            System.out.println("HELLO");
            RecusiveConstructor obj = new RecusiveConstructor();
        } catch (StackOverflowError e) {
            
        }
    }

    public static void main(String[] args) {
        RecusiveConstructor obj1 = new RecusiveConstructor();
    }
}