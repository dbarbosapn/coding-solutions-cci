import java.util.*;

public class Solution {

    public static boolean isUnique(String s) {
        if (s.length() > 256)
            return false;
        int stored = 0;
        for (int i = 0; i < s.length(); i++) {
            int val = s.charAt(i);
            if ((stored & (1 << val)) > 0)
                return false;
            stored |= (1 << val);
        }
        return true;
    }

}