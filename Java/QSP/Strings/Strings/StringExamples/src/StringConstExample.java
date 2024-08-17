import java.sql.SQLOutput;

public class StringConstExample {
    public static void main(String[] args) {
//        String a = "HELLO";
//        String b = "HELLO";
//        String c = new String("WORLD");
//        String d = "WORLD";
//        String e = "WORLD";
//        System.out.println(a==b); // True
//        System.out.println(c==d); // False
//        System.out.println(d==e); // True
//        System.out.println(a.hashCode());
//        System.out.println(b.hashCode());

//        String a = "Hello";
//        String b = "_World";
//        String c = "Hello_World";
//        String d = "Hello" + b;
//        System.out.println(c==d);
//        System.out.println(c.hashCode());
//        System.out.println(d.hashCode());
//        System.out.println(c);
//        System.out.println(d);

        String a = "Hello";
        String b = " Java";
        String c = "Hello Java";
        String d = "Hello Java";
        String e = new String("Hello Java");
        String f = a + b;
        System.out.println(a == b);
        System.out.println(c == e);
        System.out.println(c == d);
        System.out.println(e == f);
        System.out.println(c.equals(e));
        System.out.println(e.equals(f));

    }
}
