/*
you are given a string S. 
You have to divide the string into subsequences such that 
every character of S is present in only one subseqeunce 
and every subsequence has the same set of characters. 
Your task if to find and return the maximum possible number of subsequences 
into which you can divide the given string. 

input1 = abcabcab
output = 2 

input2 = aaabbbccca
output = 3 


*/


import java.util.HashMap;
import java.util.Map;

public class Test2 {
    public static int maxSubsequences(String s) {
        // Frequency map to count the occurrences of each character
        Map<Character, Integer> frequencyMap = new HashMap<>();
        
        // Populate the frequency map
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        
        // Find the maximum frequency
        int maxFrequency = 0;
        for (int frequency : frequencyMap.values()) {
            maxFrequency = Math.max(maxFrequency, frequency);
        }
        
        // The maximum number of subsequences is equal to the maximum frequency
        return maxFrequency ;
    }

    public static void main(String[] args) {
        String input1 = "aaabbbccca";
        System.out.println(maxSubsequences(input1)); // Output: 2
    }
}
