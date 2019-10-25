public class Solution {

    public static void deleteMiddleNode(LinkedListNode node) {
        while (node.getNext().getNext() != null) {
            node.setValue(node.getNext().getValue());
            node = node.getNext();
        }
        node.setValue(node.getNext().getValue());
        node.setNext(null);
    }

}