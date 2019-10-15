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

## This is actually a very good algorithm but then we're asked to do it with O(1) space, that means, no additional space.

If we're supposed to not use additional space, we must manipulate the string.
So, we can order it and then look for consecutive equal characters.

```java
import java.util.*;

public static boolean isUnique(String s) {
    char[] characters = s.toCharArray();
    Arrays.sort(characters); // According to the java API, we're using Quicksort here - O(nlog(n))
    for(int i = 0; i < characters.length - 1; i++) if(characters[i] == characters[i+1]) return false;
    return true;
}
```

This would take O(1) space and O(nlog(n) + n) time, which is still O(nlog(n))
