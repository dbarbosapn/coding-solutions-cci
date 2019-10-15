import java.util.*;

public class Solution {
    public static boolean isPalindromePermutation(String string) {
        // We will use a map instead of an array because it
        // will be easier to ignore non digit and non letter characters
        Map<Character, Integer> map = new HashMap<>();
        buildMap(string, map);

        boolean foundOdd = false;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 != 0 && foundOdd)
                return false;
            else if (entry.getValue() % 2 != 0)
                foundOdd = true;
        }
        return true;
    }

    private static void buildMap(String string, Map<Character, Integer> map) {
        for (char c : string.toCharArray()) {
            if(Character.isLetter(c)) c = Character.toLowerCase(c);
            if (Character.isDigit(c) || Character.isLetter(c)) {
                if (!map.containsKey(c))
                    map.put(c, 1);
                else
                    map.put(c, map.get(c) + 1);
            }
        }
    }
}