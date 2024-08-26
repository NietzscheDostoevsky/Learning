import java.util.HashMap;

public class FrequencyCount {

    public static void main(String[] args) {
        String test = "a a b d f d g d a a f w a d f a f s w s s f s f s a d f a";

        HashMap<String, Integer> dict = new HashMap<>();

        String[] testArr = test.split(" ");
        for (String word: testArr)
            if (!dict.containsKey(word)) dict.put(word, 1);
            else dict.put(word, dict.get(word) + 1);


        for (String word: dict.keySet())
            System.out.println(word + ": " + dict.get(word) );

    }
}
