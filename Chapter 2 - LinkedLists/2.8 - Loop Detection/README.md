# Loop Detection

## We're asked to implement an algorithm to return the node at the beginning of a loop, if it exists

When I read the title <strong>Loop Detection</strong> I immediately thought about the <em>Floyd's Tortoise and Hare</em> algorithm. That already solves our loop detection problem. The difficulty comes when they ask us to find the beginning of the loop.
After some minutes on the paper, I noticed that the collision point is always the same distance from the start of the loop as the start of the list. And we can prove that with some math.
Anyway, we already have everything we need.

Let's implement that?

```java
public static LinkedListNode loopDetection(LinkedListNode head) {
    if (head == null)
        return null;

    LinkedListNode slow = head;
    LinkedListNode fast = head;

    while (fast != slow) {
        if (fast == null || fast.getNext() == null)
            return null;
        slow = slow.getNext();
        fast = fast.getNext().getNext();
    }

    // Keep the fast in the collision point, move the slow to the start and find the
    // new collision point
    slow = head;

    while (fast != slow) {
        slow = slow.getNext();
        fast = fast.getNext();
    }

    return fast;
}
```

This algorithm takes O(1) space and O(L + S) time, where L is the size of the loop and S the index of the first element of the cycle. :tada:
