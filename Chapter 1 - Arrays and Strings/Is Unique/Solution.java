import java.util.*;

public class Solution {

    public static boolean isUnique(String s) {
        char[] characters = s.toCharArray();
        Arrays.sort(characters);
        for (int i = 0; i < characters.length - 1; i++)
            if (characters[i] == characters[i + 1])
                return false;
        return true;
    }

}