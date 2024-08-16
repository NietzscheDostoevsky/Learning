public class CLIAddition {
    public static void main(String[] args) {

        if (args.length < 2) {
            System.out.println("only two arguments allowed. ");
            return;
        }

        try {
            int num1 = Integer.parseInt(args[0]);
            int num2 = Integer.parseInt(args[1]);


            String result = String.format("Addition of %d and %d = %d", num1, num2, addition(num1, num2));
            System.out.println(result);
        } catch (NumberFormatException e) {
            System.out.println("ONly input integers ");
        }
    }

    public static int addition(int n1, int n2) {
        return n1 + n2;
    }
}
