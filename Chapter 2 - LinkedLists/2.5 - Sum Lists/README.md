# Sum Lists

## We're asked to implement an algorithm to sum two lists that represent two numbers

The author of this problem makes it easier for us by giving us the numbers in reverse order in the list.
In this case, we can apply simple arithmetics on every digit.

Let's implement that?

```java
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
```

This would take O(n) space and O(n) time. :tada:

## As a follow-up question, we're asked to solve the problem with the lists in reverse order

The way i'd solve this is to first reverse the lists and then apply the same function. It doesn't change the complexity as we take O(n) for each list to reverse.
So, we get O(2n + n) which is still O(n). :tada:
