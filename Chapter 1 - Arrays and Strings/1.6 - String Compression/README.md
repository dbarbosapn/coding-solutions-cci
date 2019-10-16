# String Compression

## We're asked to implement an algorithm to 'compress' a string. Example: "aaabbc" becomes "a3b2c1". Also, if the compressed string is smaller than the original, return the original.

There are two ways that came to my mind. The faster one is to do it in one pass. Everytime the character changes, we reset a counter and keep building the string.
Although this is faster, I wouldn't say it's the 'prettiest' way of doing it. I would first save the frequencies in an hashtable and then build the string based on that. That would still be O(n), despite being a little bit slower. The problem is, if we have "bbab" this method would give "b3a1", which is not what we want. So, we'll have to stick with the first one. Bonus: This method will work for every character possible.

Let's implement that?

```java
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
```

This would take O(n) space and O(n) time, for n = number of characters on the string
