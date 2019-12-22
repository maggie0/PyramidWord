import java.util.HashMap;
import java.util.Map;

import static java.lang.StrictMath.sqrt;

public class PyramidWord {
    // The time complexity is O(n), where n is the length of word.
    public boolean pyramidWord(String word) {
        if (word == null)
            return false;
        // Check if the length of the word is valid or not.
        // If the word is a pyramid word, there will exist int k such that len = 1+2+3+...+k = k*(k+1)/2.
        // That is, the quadratic equation k^2 + k - 2*len = 0 needs to have a positive integer solution.
        int len = word.length();
        // Solve the equation and take the integer part of the positive solution.
        int k = (-1 + (int)sqrt(1 + 8*len)) / 2;
        // Check whether the k strictly satisfies k^2 + k - 2*len = 0.
        // If not, then it means there is no way we can get a pyramid word with length len.
        if ((k * (k+1)) / 2 != len) {
            return false;
        }
        // Create a hash map to save the frequency of each character.
        // There should be k unique characters and the frequencies of them should also be distinct which are from 1 to k.
        Map<Character, Integer> count = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (!count.containsKey((word.charAt(i)))) {
                count.put(word.charAt(i), 1);
            } else {
                int newCount = count.get(word.charAt(i)) + 1;
                // The frequencies of characters should between 1 and k.
                // If the frequency of a character is greater than k, return false.
                if (newCount > k) {
                    return false;
                }
                count.put(word.charAt(i), newCount);
            }
        }
        // The number of unique characters is not k, return false.
        if (count.size() != k) {
            return false;
        }
        // Create an integer array to save how many time each frequency appears.
        // If a frequency appears more than once, return false.
        int[] freqCount = new int[k + 1];
        for (int freq : count.values()) {
            if (++freqCount[freq] > 1) {
                return false;
            }
        }
        // Up to now, the largest frequency is not greater than k.
        // Each frequency doesn't appear more than once and len = 1+2+3+...+k is satisfied.
        // So, the only possible scenario is that we have k distinct frequencies: 1, 2, ... , k.
        // So, they can form a pyramid word for sure.
        return true;
    }
    public static void main(String[] args) {
        if (args.length < 1) {
            throw new IllegalArgumentException("Number of arguments should be at least 1!");
        }
        PyramidWord pw = new PyramidWord();
        if (pw.pyramidWord(args[0])) {
            System.out.println(args[0] + " is a pyramid word");
        } else {
            System.out.println(args[0] + " is not a pyramid word");
        }
    }
}
