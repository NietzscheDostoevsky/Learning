import java.util.Scanner;

public class AlphabetCharCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the alphabet : ");
        char ch = sc.next().toLowerCase().charAt(0);

        boolean logic = (ch > 96 && ch < 123);
        String str1 = logic ? " an Alphabet" : "not an alphabet";
        String str2 = String.format("The entered character %c is %s", ch, str1);
        System.out.println(str2);

    }

}
