public class BoolTest {
    public static void main(String[] args) {
        boolean b;

        b = false;
        System.out.println(b);
        b = true;
        System.out.println(b);

        // A bool val can control the if statement

        if (b)
            System.out.println("This line will be executed");
        b = false;
        if (b)
            System.out.println("This line should not be executed");

    }
}
