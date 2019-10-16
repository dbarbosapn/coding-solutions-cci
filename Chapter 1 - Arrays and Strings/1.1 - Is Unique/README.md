# Is Unique

## We're asked to implement an algorithm to determine if a string has all unique characters.

The first algorithm that comes to the mind is to save the characters in a set and verify if it exists when adding a new one.

```java
public static boolean isUnique(String s) {
    Set<Character> set = new HashSet<>();
    for(char c : s.toCharArray()) if(!set.add(c)) return false;
    return true;
}
```

This would take O(n) space and O(n) time, for n = number of characters.

## This is actually a very good algorithm but then we're asked to do it with O(1) space.

If we're supposed to not use additional space, we must manipulate the string.
So, we can order it and then look for consecutive equal characters.

```java
public static boolean isUnique(String s) {
    char[] characters = s.toCharArray();
    Arrays.sort(characters); // According to the java API, we're using Quicksort here - O(nlog(n))
    for(int i = 0; i < characters.length - 1; i++) if(characters[i] == characters[i+1]) return false;
    return true;
}
```

This would take O(1) space and O(nlog(n) + n) time, which is still O(nlog(n))

## Is it possible to make it O(n) time? Sure!

We could make an array as big as the number of possible characters in ASCII (256 counting with the special characters).
Since we will assume there will only be lowercase letters in the string we can use bitwise operations on an integer.
Also, if the length of the string is bigger than the number of possible characters, we already know there must be one repeated.

```java
public static boolean isUnique(String s) {
    if (s.length() > 256) return false;
    int stored = 0;
    for (int i = 0; i < s.length(); i++) {
        int val = s.charAt(i);
        if((stored & (1 << val)) > 0) return false;
        stored |= (1 << val);
    }
    return true;
}
```

This would still take O(1) (constant, not less) space and O(n) time! Yay! :tada:
