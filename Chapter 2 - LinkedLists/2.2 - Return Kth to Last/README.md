# Return Kth to Last

## We're asked to implement an algorithm to return the Kth to last element in a singly linked list

The first, and usually the not so optimal, solution that comes to the mind is to first find the length of the list and then go through length-k nodes.
As the book tells us, we should alwaýs try to avoid repetitive work.

A very easy way to fix this is to have a "runner" node that starts first and when this runner reaches the kth node, we start with the slow one. This way, when the runner reaches <i>length</i>, the slow node will be at <i>length - k</i>.

Let's implement that?

```java
public static LinkedListNode kthToLast(LinkedListNode head, int k) {
    LinkedListNode runner = head;
    LinkedListNode slow = head;

    for (int i = 0; i < k; i++) {
        runner = runner.getNext();
    }

    while (runner != null) {
        runner = runner.getNext();
        slow = slow.getNext();
    }

    return slow;
}
```

This would take O(1) space and O(n) time. :tada:
