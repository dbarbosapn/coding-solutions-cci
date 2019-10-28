public class Solution {

    public static LinkedListNode sumLists(LinkedListNode l1, LinkedListNode l2) {
        return sumLists(l1, l2, 0);
    }

    public static LinkedListNode sumLists(LinkedListNode l1, LinkedListNode l2, int carry) {
        if(l1 == null && l2 == null && carry == 0) return null;

        LinkedListNode answer = new LinkedListNode();

        int sum = carry;
        if(l1 != null) {
            sum += l1.getValue();
            l1 = l1.getNext();
        }
        if(l2 != null) {
            sum += l2.getValue();
            l2 = l2.getNext();
        }

        answer.setValue(sum % 10);
        carry = sum / 10;

        if(l1 != null || l2 != null) {
            LinkedListNode append = sumLists(l1, l2, carry);
            result.setNext(append);
        }

        return result;
    }

}