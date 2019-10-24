# Remove Dups

## We're asked to implement an algorithm to remove the duplicates from an unsorted linked list.

This is pretty straightforward. If we save every element in an HashSet, we could do a very efficient algorithm.

Let's implement that?

```java
public static void removeDups(LinkedListNode n) {
    Set<Integer> set = new HashSet<Integer>();
    LinkedListNode previous = null;
    while(n != null) {
        if(set.contains(n.getValue()) {
            previous.setNext(n.getNext());
        } else {
            set.add(n.getValue());
            previous = n;
        }
        n = n.getNext();
    }
}
```

This would take O(n) space and O(n) time! Quite good. :tada:

## As a follow-up question, we're asked to do this without a temporary buffer

Well, goodbye HashSet. Guess we'll have to do something different here.
We can, basically, as we traverse the list, delete every node equal to the current one. Not very efficient, but it's the best we can do.

Let's implement that?

```java
public static void removeDups(LinkedListNode n) {
    while(n != null) {
        LinkedListNode runner = n;
        while(runner.getNext() != null) {
            if(runner.getNext().getValue() == n.getValue()) runner.setNext(runner.getNext().getNext());
            else runner = runner.getNext();
        }
        n = n.getNext();
    }
}
```

Yes, this code takes O(1) space but O(n<sup>2</sup>) time. We have to understand why we're asked to do this.
In some situations, waiting 1 day for a program to finish is better than needing 1 million terabytes of memory.
It's all about scalability. Keep that in mind.
