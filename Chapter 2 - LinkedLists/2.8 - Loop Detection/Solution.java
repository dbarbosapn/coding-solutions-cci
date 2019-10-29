public class Solution {

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

}