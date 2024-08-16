public class UnboxingExample {
    public static void main(String[] args) {
        Integer a = 10;
        //int b = a; // compiler implixitely ie autounboxing.
        int b = a.intValue();
        System.out.println(b);

        Boolean c = true;
        boolean d = c.booleanValue();
        System.out.println(d);
    }
}
