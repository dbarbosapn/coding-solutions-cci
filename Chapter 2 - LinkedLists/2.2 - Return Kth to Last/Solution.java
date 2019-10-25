public class Solution {

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

}