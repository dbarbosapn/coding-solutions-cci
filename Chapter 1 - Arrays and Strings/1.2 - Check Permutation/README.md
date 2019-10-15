# Check Permutation

## Given two strings, write a method to decide if one is a permutation of the other

The most obvious approach would be to first compare the lengths. If they're different, they are not permutations.
Then we would sort the strings and check if they are equal. This would take O(nlog(n)). Can we do it in O(n)?

Ofc we can! Let's use the same technique as the last exercise. Take an array of integers and save the frequency of each character in the first string.
Then, when we scan through the second string and decrement the integer on the array for the corresponding character. If the frequency is already 0, they are not permutations.
Let's implement that!

```java
public static boolean checkPermutation(String s1, String s2) {
    if(s1.length() != s2.length()) return false;
    int[] array = new int[256];
    for(char c : s1.toCharArray()) array[c]++;
    for(char c : s2.toCharArray()) {
        if(array[c] == 0) return false;
        array[c]--;
    }
    return true;
}
```

This would take O(1) space and O(2n) time, which is still O(n). Since we know we have to touch every string, we know this is the best possible runtime.
