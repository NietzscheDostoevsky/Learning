interface MyInterface {
    // Public default method
    default void show() {
        System.out.println("Default Method");
        log("Log from default method");
    }
    
    // Another public default method
    default void display() {
        System.out.println("Another Default Method");
        log("Log from another default method");
    }
    
    // Public static method
    static void print() {
        System.out.println("Static Method");
        staticLog("Log from static method");
    }
    
    // Private instance method
    private void log(String message) {
        System.out.println("Logging: " + message);
    }
    
    // Private static method
    private static void staticLog(String message) {
        System.out.println("Static Logging: " + message);
    }
}

public class Main implements MyInterface {
    public static void main(String[] args) {
        Main obj = new Main();
        obj.show();
        obj.display();
        
        MyInterface.print();
    }
}
