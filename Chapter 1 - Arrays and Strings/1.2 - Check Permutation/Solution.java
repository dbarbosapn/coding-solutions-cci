public class Solution {

    public static boolean checkPermutation(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;
        int[] array = new int[256];
        for (char c : s1.toCharArray())
            array[c]++;
        for (char c : s2.toCharArray()) {
            if (array[c] == 0)
                return false;
            array[c]--;
        }
        return true;
    }

}