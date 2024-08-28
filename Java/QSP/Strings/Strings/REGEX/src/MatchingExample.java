import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchingExample {
    public static void main(String[] args) {

        String regex = "[ab]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher("abracadabara");

        while(matcher.find()) {
            System.out.println(matcher.start() + "______" + matcher.group());
        }
    }
}
