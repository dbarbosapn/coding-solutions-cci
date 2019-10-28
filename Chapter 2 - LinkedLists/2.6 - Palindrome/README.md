# Palindrome

## We're asked to implement an algorithm to verify if a list is a palindrome

There are two O(n) solutions that come to my mind. The first one is to reverse the list and verify if it is equal to the original.
That would take O(2n) time and O(n) space.
The other way is to first find the middle of the list and then check if the elements on a stack containing the first half are equal to the second half.
This would take O(n) time and O(n/2) space.
I'll choose the second one.

Let's implement that?

```java
public static boolean isPalindrome(LinkedListNode head) {
    if (head == null)
        return true;

    LinkedListNode slow = head;
    LinkedListNode fast = head;

    Stack<Integer> firstHalf = new Stack<>();

    while (fast != null && fast.getNext() != null) {
        firstHalf.push(slow.getValue());
        slow = slow.getNext();
        fast = fast.getNext().getNext();
    }

    if (fast != null)
        slow = slow.getNext();

    while (slow != null) {
        if (firstHalf.pop() != slow.getValue())
            return false;
        slow = slow.getNext();
    }

    return true;
}
```

As we've already seen, this algorithm takes O(n) space and O(n) time. :tada:
