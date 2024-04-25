// To use something other than out to print the lines

import java.io.PrintStream;

public class PrintSt {
    public static void main(String[] args) {

        PrintStream tiger = new PrintStream(System.out);
        tiger.println("this is printing from new ");

    }
}