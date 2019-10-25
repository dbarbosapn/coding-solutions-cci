# Partition

## We're asked to implement an algorithm to partition a linked list around a value

First, we need to understand what the problem means by a "partition".
Basically, in a partition of K, we want to put every value smaller than K before it and every bigger value after it.
So, we can keep a left list and a right list, merge the two and return the head!

Let's implement that?

```java
public static void partition(LinkedListNode head, int k) {
    LinkedListNode left = null;
    LinkedListNode leftStart = null;
    LinkedListNode right = null;
    LinkedListNode rightStart = null;

    while (head != null) {
        int value = head.getValue();
        if (value < k) {
            if (left == null) {
                left = head;
                leftStart = left;
            } else {
                left.setNext(head);
                left = left.getNext();
            }
        } else {
            if (right == null) {
                right = head;
                rightStart = right;
            } else {
                right.setNext(head);
                right = right.getNext();
            }
        }
        head = head.getNext();
    }

    left.setNext(rightStart);

    return leftStart;

}
```

This would take O(1) space and O(n) time. :tada:
