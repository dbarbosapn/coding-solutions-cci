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