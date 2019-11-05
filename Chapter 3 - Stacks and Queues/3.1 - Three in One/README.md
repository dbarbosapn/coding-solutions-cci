# Three in One

## We're asked to implement a class that holds 3 stacks in one array

I think this problem is not hard at all. It's just a lot of work! A simple way to solve this problem is to divide the array in 3 equal parts and use each part as a stack of fixed max size. We will actually make a class that already implements this for different numbers of stacks and sizes.

Let's implement that?

```java
class MultiStack<T> {

    private int numberOfStacks = 3;
    private int stackMaxSize;
    private T[] array;
    private int[] stackSizes;

    public MultiStack(int numberOfStacks, int stackMaxSize) {
        this.numberOfStacks = numberOfStacks;
        this.stackMaxSize = stackMaxSize;
        this.array = new int[numberOfStacks * stackMaxSize];
        this.stackSizes = new int[numberOfStacks];
    }

    /**
     * Adds a value to the stack. Returns true if successful, false otherwise.
     */
    public boolean push(T value, int stack) {
        if(isFull(stack)) return false;
        stack = stack - 1;
        int offset = stack * stackMaxSize;
        array[stackSizes[stack] + offset - 1] = value;
        stackSizes[stack]++;
    }

    /**
     * Removes a value to the stack. Returns that value.
     */
    public T pop(int stack) {
        stack = stack - 1;
        if(stackSizes[stack] == 0) return null;
        int offset = stack * stackMaxSize;
        T returnValue = array[stackSizes[stack] + offset - 2];
        stackSizes[stack]--;
        return returnValue;
    }

    /**
     * Returns the value at the top of the stack
     */
    public T peek(int stack) {
        stack = stack - 1;
        if(stackSizes[stack] == 0) return null;
        int offset = stack * stackMaxSize;
        return array[stackSizes[stack] + offset - 2];
    }


    /**
     * Checks if the given stack is full
     */
    public boolean isFull(int stack) {
        return stackSizes[stack - 1] == stackMaxSize;
    }

}
```

This algorithm takes O(stackMaxSize \* numberOfStacks) space and O(1) time for each operation :tada:
