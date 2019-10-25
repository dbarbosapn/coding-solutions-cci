public class Solution {

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

}