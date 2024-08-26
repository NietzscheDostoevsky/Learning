import java.util.Arrays;
import java.util.HashSet;

public class VovelToUpperCase {
    public static void main(String[] args) {
        String str = "abracadabra";
        System.out.println(vovelToUpperCase(str));  // Output:
    }

    private static String vovelToUpperCase(String str) {

        HashSet<Character> v = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        String str1 = str.toLowerCase();
        StringBuffer result = new StringBuffer();
        for (char ch : str1.toCharArray())
            if (v.contains(ch))
                result.append((char) (ch - 32));
            else
                result.append(ch);
        return new String(result);


    }
}
