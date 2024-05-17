import java.util.Scanner;

class Calculator {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Num1 :");
        double num1 = sc.nextDouble();
        System.out.print("Enter Num2 : ");
        double num2 = sc.nextDouble();
        System.out.print("Enter Operator : ");
        char op = sc.next().charAt(0);
        double result = 0;

        // logic

        if (op == '+' || op == '-' || op == '/' || op == '*') {

            if (op == '+')
                result = num1 + num2;
            if (op == '-')
                result = num1 - num2;
            if (op == '*')
                result = num1 * num2;
            if (op == '/')
                result = num1 / num2;

            System.out.println(num1 + " " + op + " " + num2 + " = " + result);

        } else {
            System.out.println("Enter correct operand");
        }

    }
}