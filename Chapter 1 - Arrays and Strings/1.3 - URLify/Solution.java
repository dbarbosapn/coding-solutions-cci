public class Solution {

    public static void URLify(char[] string, int length) {
        char[] clone = string.clone();
    
        for(int i = 0, j = 0; i < length; i++, j++) {
            if(clone[j] == ' ') {
                length += 2;
                string[i++] = '%';
                string[i++] = '2';
                string[i] = '0';
            } else string[i] = clone[j];
        }
    
        string[length] = '\0';
    
    }

}