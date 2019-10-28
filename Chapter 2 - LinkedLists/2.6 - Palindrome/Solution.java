public class Solution {

    public static boolean isPalindrome(LinkedListNode head) {
        if (head == null)
            return true;

        LinkedListNode slow = head;
        LinkedListNode fast = head;

        Stack<Integer> firstHalf = new Stack<>();

        while (fast != null && fast.getNext() != null) {
            firstHalf.push(slow.getValue());
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }

        if (fast != null)
            slow = slow.getNext();

        while (slow != null) {
            if (firstHalf.pop() != slow.getValue())
                return false;
            slow = slow.getNext();
        }

        return true;
    }

}