import java.util.Scanner;

public class UpperLowerDigitCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the alphabet : ");
        char ch = sc.next().charAt(0);

        boolean isLower = (ch > 96 && ch < 123);
        boolean isUpper = (ch > 64 && ch < 91);
        boolean isDigit = (ch > 47 && ch < 58);

        String result = isLower ? "Lowercase character" :  // Think of char as if else loop 
                        isUpper ? "UpperCase character" : 
                        isDigit ? "Digit" : 
                        "Special Character" ;
        String str = String.format("The entered character %c is a %s ", ch, result); 
        System.out.println(str);
        
    }

}
