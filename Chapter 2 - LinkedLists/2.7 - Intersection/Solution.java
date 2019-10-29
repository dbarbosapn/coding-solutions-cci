public class Solution {

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

}