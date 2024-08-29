import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PredefinedMatching {
    public static void main(String[] args) {
        String regex = "\d";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher("abracadabara\n");

        while(matcher.find()) {
            System.out.println(matcher.start() + " ______ " + matcher.group());
        }
    }
}
