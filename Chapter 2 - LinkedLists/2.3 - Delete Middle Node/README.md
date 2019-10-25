# Delete Middle Node

## We're asked to implement an algorithm to delete a node with only access to that node

This problem is more like a <i>brainteaser</i> in the sense that it's all about a simple trick to solve it.

There's really no way to delete a node without access to its previous node.
The trick is simple. It's another one of those (like in <strong>1.9 - String Rotation</strong>) where when you know it, you can't forget it.

If we're at a middle node, we can keep copying the next node's value to the current one and delete the last one.
See how easy it is?

Let's implement that?

```java
public static void deleteMiddleNode(LinkedListNode node) {
    while(node.getNext().getNext() != null) {
        node.setValue(node.getNext().getValue());
        node = node.getNext();
    }
    node.setValue(node.getNext().getValue());
    node.setNext(null);
}
```

This would take O(1) space and O(k) time, where k is the length between the last and the given node. :tada:
