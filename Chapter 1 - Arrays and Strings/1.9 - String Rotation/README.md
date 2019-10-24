# String Rotation

## We're asked to implement an algorithm to check if a string is a rotation of another

First, we need to understand what being a rotation is. The book's example is very straightforward. "waterbottle" is a rotation of "erbottlewat".

Just with this information, we already know that one string should be the same size as the other.
We could try to check char by char if it meets the condition. However, we're given a method called "isSubstring" that tells us if a string is substring of another.
Also, we can only use one call to this method.

This is one of those problems where after we find the solution once, we can never forget it. And it's pretty easy!

Look what happens if we concatenate the first or second string with itself: "waterbottlewatterbottle".
Look closely... "wat*erbottlewat*erbottle"

No need to say anything else, am I right?

Let's implement that?

```java
public static boolean isRotation(String s1, String s2) {
    if (s1.length() == s2.length() && s1.length() > 0) {
        String concat = s1 + s1;
        return isSubstring(concat, s2);
    }
    return false;
}
```

This would take O(n) space and O(n) time, if we assume isSubstring runs in O(concat.length() + s2.length()) time.
