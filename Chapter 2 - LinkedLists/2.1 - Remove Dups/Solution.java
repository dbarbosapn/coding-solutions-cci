public class Solution {

    public static void removeDups(LinkedListNode n) {
        while (n != null) {
            LinkedListNode runner = n;
            while (runner.getNext() != null) {
                if (runner.getNext().getValue() == n.getValue())
                    runner.setNext(runner.getNext().getNext());
                else
                    runner = runner.getNext();
            }
            n = n.getNext();
        }
    }

}