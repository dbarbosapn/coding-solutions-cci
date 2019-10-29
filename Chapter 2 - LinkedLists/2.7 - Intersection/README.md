# Intersection

## We're asked to implement an algorithm to return the intersecting node in a list, if it exists

First thing I noticed is that if the lists are the same size, if we traverse them at the same time, when the nodes are equal that's the intersection.
The problem is when the lists are of different sizes. So, to fix this, we can ignore the first nodes of the longer list.
Also, as we find the sizes of the two lists, we can already check if there's an intersection. Because if there is, then the final node will be equal in both lists.

Let's implement that?

```java
public static LinkedListNode intersection(LinkedListNode l1, LinkedListNode l2) {
    if (l1 == null || l2 == null)
        return null;

    LinkedListNode head1 = l1;
    LinkedListNode head2 = l2;

    int size1 = 1;
    int size2 = 1;

    // Get the sizes and move head to tail
    while(head1.getNext() != null || head2.getNext() != null) {
        if(head1.getNext() != null) {
            size1++;
            head1 = head1.getNext();
        }
        if(head2.getNext() != null) {
            size2++;
            head2 = head2.getNext();
        }
    }

    // Checks if the tails are equal
    if(head1 != head2) return null;

    LinkedListNode longer = (size1 > size2) ? l1 : l2;
    LinkedListNode shorter = (size1 < size2) ? l2 : l1;

    // Move longer to the size difference
    for(int i = 0; i < Math.abs(size1 - size2); i++) longer = longer.getNext();

    // Check for intersection node
    while(longer != null && shorter != null) {
        if(longer == shorter) return longer;
        longer = longer.getNext();
        shorter = shorter.getNext();
    }

    return null;
}
```

This algorithm takes O(1) space and O(L) time, where L is the size of the longer list. :tada:
