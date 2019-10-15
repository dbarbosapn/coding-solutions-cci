# URLify

## We're asked to implement an algorithm to replace spaces in a string with '%20'

The way I'd do this is to create a new array that is a copy of the current char array and use a variation of a 'sliding window' on both arrays.
Let's see...

```java
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
```

This would take O(n) space and O(n) time, for n = number of characters. Done! :tada:
