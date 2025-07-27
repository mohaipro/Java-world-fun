import java.util.ArrayList;

/**
 * Stack implementation using ArrayList
 * 
 * Advantages:
 * - Dynamic resizing (no fixed capacity limit)
 * - Easy to implement using ArrayList methods
 * 
 * Disadvantages:
 * - Slightly more overhead than array implementation
 * - Requires object wrappers for primitives
 */
class MyStack {
    private ArrayList<Integer> arr;
    private int capacity;
    
    /**
     * Constructor to initialize stack with given capacity
     * @param capacity The initial capacity of the stack
     */
    public MyStack(int capacity) {
        this.capacity = capacity;
        this.arr = new ArrayList<Integer>(this.capacity);
        System.out.println("Creating a stack with capacity: " + this.capacity);
    }
    
    /**
     * Pushes an element onto the stack
     * @param x The element to push
     */
    public void push(Integer x) {
        this.arr.add(x);
    }
    
    /**
     * Removes and returns the top element of the stack
     * @return The top element
     * @throws RuntimeException if stack is empty
     */
    public Integer pop() {
        if (empty()) {
            throw new RuntimeException("Cannot pop from empty stack");
        }
        return this.arr.remove(this.arr.size() - 1);
    }
    
    /**
     * Returns the top element without removing it
     * @return The top element
     * @throws RuntimeException if stack is empty
     */
    public Integer peek() {
        if (empty()) {
            throw new RuntimeException("Cannot peek empty stack");
        }
        return this.arr.get(this.arr.size() - 1);
    }
    
    /**
     * Returns the current size of the stack
     * @return Number of elements in stack
     */
    public Integer size() {
        return this.arr.size();
    }
    
    /**
     * Checks if stack is empty
     * @return true if stack is empty, false otherwise
     */
    public boolean empty() {
        return this.arr.isEmpty();
    }
    
    /**
     * Searches for an element in the stack
     * @param x The element to search for
     * @return The 1-based position from top, or -1 if not found
     * Note: This implementation is destructive as it pops elements during search
     */
    public Integer search(Integer x) {
        int count = 0;
        int index = -1;
        for (int i = this.arr.size() - 1; i >= 0; i--) {
            count++;
            int poppedValue = this.pop();
            if (poppedValue == x) {
                index = i;
                break;
            }
        }
        System.out.println("Search operations performed: " + count);
        return index;
    }
}
