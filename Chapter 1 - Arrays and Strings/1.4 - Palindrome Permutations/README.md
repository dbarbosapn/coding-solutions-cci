# Palindrome Permutations

## We're asked to implement an algorithm to find if a string is a permutation of a palindrome

We would probably think about generating all the permutations and then see if it contains the current string. That would be O(n!). That is SO ridiculously slow for a big N!
Let's think for a bit, shall we?
What is something that does not change between permutations? The frequency of each character!
What's unique about the frequency of palindrome's characters? They are all even with a max of 1 character odd!

Let's implement that?

```java
public static boolean isPalindromePermutation(String string) {
    // We will use a map instead of an array because it
    // will be easier to ignore non digit and non letter characters
    Map<Character, Integer> map = new HashMap<>();
    buildMap(string, map);

    boolean foundOdd = false;
    for (Map.Entry<Character, Integer> entry : map.entrySet()) {
        if (entry.getValue() % 2 != 0 && foundOdd)
            return false;
        else if (entry.getValue() % 2 != 0)
            foundOdd = true;
    }
    return true;
}

private static void buildMap(String string, Map<Character, Integer> map) {
    for (char c : string.toCharArray()) {
        if(Character.isLetter(c)) c = Character.toLowerCase(c);
        if (Character.isDigit(c) || Character.isLetter(c)) {
            if (!map.containsKey(c))
                map.put(c, 1);
            else
                map.put(c, map.get(c) + 1);
        }
    }
}
```

This would take O(n) space and O(N) time, for n = number of UNIQUE characters and N = number of characters. Done! :tada:
