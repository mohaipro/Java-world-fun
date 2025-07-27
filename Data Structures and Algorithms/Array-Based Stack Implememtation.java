/**
 * Stack implementation using primitive array
 * 
 * Advantages:
 * - Better performance for primitive types
 * - More memory efficient
 * 
 * Disadvantages:
 * - Fixed capacity
 * - Need to manually handle overflow/underflow
 */
class ArrayStack {
    private int maxSize;
    private int[] arr;
    private int top;
    
    /**
     * Constructor to initialize stack with fixed size
     * @param size Maximum capacity of the stack
     */
    public ArrayStack(int size) {
        this.maxSize = size;
        this.arr = new int[this.maxSize];
        this.top = -1; // Stack is initially empty
    }
    
    /**
     * Pushes an element onto the stack
     * @param x The element to push
     * @throws StackOverflowError if stack is full
     */
    public void push(int x) {
        if (isFull()) {
            throw new StackOverflowError("Stack is full");
        }
        this.arr[++top] = x;
    }
    
    /**
     * Removes and returns the top element
     * @return The top element
     * @throws RuntimeException if stack is empty
     */
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Cannot pop from empty stack");
        }
        return this.arr[top--];
    }
    
    /**
     * Returns the top element without removing it
     * @return The top element
     * @throws RuntimeException if stack is empty
     */
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Cannot peek empty stack");
        }
        return this.arr[top];
    }
    
    /**
     * Checks if stack is full
     * @return true if stack is full, false otherwise
     */
    public boolean isFull() {
        return (top == this.maxSize - 1);
    }
    
    /**
     * Checks if stack is empty
     * @return true if stack is empty, false otherwise
     */
    public boolean isEmpty() {
        return (top == -1);
    }
}
