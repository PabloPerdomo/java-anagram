package x.pablop315;

import java.util.HashMap;
import java.util.function.BiFunction;

public class AnagramValidator {

    /**
     * Check if left and right are anagrams
     *
     * Big O notation: O(N) being N the size of the strings
     *                 One iteration for get the letters and one iteration for compare the HashMaps (in the equals).
     *
     * @param left
     * @param right
     * @return true iff left and right anagrams.
     */
    public static boolean areAnagrams(String left, String right) {
        if (left == null) {
            return right == null;
        } else if (right == null) {
            return false;
        }
        if (left.length() != right.length()) {
            return false;
        }

        HashMap<Character, Integer> leftLetters = new HashMap<Character, Integer>();
        HashMap<Character, Integer> rightLetters = new HashMap<Character, Integer>();
        BiFunction<Character, Integer, Integer> updateFn = (ch, oldValue) -> oldValue == null ? 1 : oldValue + 1;
        for (int i = 0; i < left.length(); i++) {
            leftLetters.compute(Character.toLowerCase(left.charAt(i)), updateFn);
            rightLetters.compute(Character.toLowerCase(right.charAt(i)), updateFn);
        }

        return leftLetters.equals(rightLetters);
    }

}
