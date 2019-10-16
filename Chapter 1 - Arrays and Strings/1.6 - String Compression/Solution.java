public class Solution {

    public static String stringCompress(String string) {
        char[] array = string.toCharArray();

        StringBuilder compressed = new StringBuilder();

        char prevChar = array[0];
        int count = 1;
        for(int i = 1; i < array.length; i++) {
            if(array[i] != prevChar) {
                compressed.append(prevChar + String.valueOf(count));
                count = 1;
                prevChar = array[i];
            } else count++;
        }
        compressed.append(prevChar + String.valueOf(count));

        if(compressed.length() >= string.length()) return string;
        else return compressed.toString();
    }

}