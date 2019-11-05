# Stack Min

## We're asked to implement a stack that has a min() operation that returns the minimum in O(1) time

To solve this problem, what first comes to my mind is to simply hold a variable with the minimum. The problem is that when that minimum is removed, what was the last one? So, we have to save every instance of the minimum along with the values. I can think of two ways to do this: Either we can make a new class that holds the value and the minimum, or we can have a new stack holding the minimums. I will be using the second option for better understanding, since both solutions take O(2n) space.

Let's implement that?

```java
class MinStack<T extends Comparable<? super T>> extends Stack<T> {

    Stack<T> minStack = new Stack<>();

    public void push(T value) {
        T min = value;
        if(value > min()) min = min();
        minStack.push(min);
        super.push(value);
    }

    public T min() {
        if(minStack.isEmpty()) return null;
        return minStack.peek();
    }

    public T pop() {
        minStack.pop();
        super.pop();
    }

}
```

This algorithm takes O(2n) space and O(1) time for each operation :tada:
