public class Solution {

    public static boolean isRotation(String s1, String s2) {
        if (s1.length() == s2.length() && s1.length() > 0) {
            String concat = s1 + s1;
            return isSubstring(concat, s2);
        }
        return false;
    }

}