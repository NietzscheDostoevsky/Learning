import java.util.HashSet;

public class RemoveDuplicates {
    public static void main(String[] args) {
        String str = "abracadabra";
        System.out.println(removeDuplicates(str));  // Output: "abrcd"
    }

    private static String removeDuplicates(String str) {

        HashSet<Character> h = new HashSet<>();
        StringBuffer sb = new StringBuffer();
        for (char ch: str.toCharArray())
            if (!h.contains(ch)) {
                h.add(ch); sb.append(ch);
            }
        return new String(sb);
    }



}
