public class Solution {
    public static boolean isOneAway(String string1, String string2) {
        String biggerString = (string1.length() > string2.length()) ? string1 : string2;
        String smallerString = (string2.length() < string1.length()) ? string2 : string1;

        if (biggerString.length() - smallerString.length() > 1)
            return false;

        boolean foundChange = false;
        for (int i = 0, j = 0; j < smallerString.length(); i++, j++) {
            if (biggerString.charAt(i) != smallerString.charAt(j)) {
                if (foundChange)
                    return false;
                else {
                    foundChange = true;
                    if (biggerString.charAt(i + 1) == smallerString.charAt(j))
                        i++;
                }
            }
        }
        return true;
    }
}