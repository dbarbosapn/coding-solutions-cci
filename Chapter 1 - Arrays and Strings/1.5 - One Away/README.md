# One Away

## We're asked to implement an algorithm to find if one string is only one change away from the other

The way I would do this is to keep scanning the two strings at the same time and check for changes. How can we do that?
If the current char in each string is different:
Check if the next one on the bigger string is equal, there is a change and we increment the pointer of the bigger string.
If it is not equal, this is a change but we keep the pointers as is.
If we find 2 changes, return false.

Let's implement that?

```java
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
```

This would take O(1) space and O(n) time, for n = number of characters on the smaller string
