import java.util.*;

/**
 * Double Stack Implementation using a Single Array
 * 
 * This class implements two stacks using a single array by dividing the array space
 * between the two stacks. Stack 1 grows from the start of the array forward, while
 * Stack 2 grows from the end of the array backward.
 */
public class Main {
    public static void main(String[] args) {
        // Create a two-stack structure with capacity 10
        TwoStacks stacks = new TwoStacks(10);
        
        // Demonstrate Stack 1 operations
        stacks.push1(10);
        stacks.push1(20);
        System.out.println("Stack 1 size: " + stacks.size1()); // 2
        System.out.println("Stack 2 size: " + stacks.size2()); // 0
        
        // Demonstrate Stack 2 operations
        stacks.push2(30);
        stacks.push2(40);
        System.out.println("Peek Stack 1: " + stacks.peek1()); // 20
        System.out.println("Peek Stack 2: " + stacks.peek2()); // 40
    }
}

/**
 * TwoStacks class that implements two stacks using a single array
 */
public class TwoStacks {
    private Integer[] arr;  // Single array to hold both stacks
    private int top1;       // Pointer for Stack 1 (starts at -1)
    private int top2;       // Pointer for Stack 2 (starts at capacity)
    private int capacity;   // Total capacity for both stacks

    /**
     * Constructor to initialize the two stacks
     * @param capacity Total capacity for both stacks combined
     */
    public TwoStacks(int capacity) {
        this.capacity = capacity;
        this.arr = new Integer[capacity];
        this.top1 = -1;             // Stack 1 grows from left to right
        this.top2 = capacity;       // Stack 2 grows from right to left
        System.out.println("Created a two-stacks array with capacity: " + capacity);
    }

    /* Stack 1 Operations */

    /**
     * Pushes an element onto Stack 1
     * @param value The element to push
     * @throws StackOverflowError if Stack 1 is full
     */
    public void push1(Integer value) {
        if (isFull1()) {
            throw new StackOverflowError("Stack 1 is full");
        }
        arr[++top1] = value;
    }

    /**
     * Pops an element from Stack 1
     * @return The popped element
     * @throws EmptyStackException if Stack 1 is empty
     */
    public Integer pop1() {
        if (isEmpty1()) {
            throw new EmptyStackException();
        }
        return arr[top1--];
    }

    /**
     * Peeks at the top element of Stack 1
     * @return The top element
     * @throws EmptyStackException if Stack 1 is empty
     */
    public Integer peek1() {
        if (isEmpty1()) {
            throw new EmptyStackException();
        }
        return arr[top1];
    }

    /**
     * Checks if Stack 1 is empty
     * @return true if empty, false otherwise
     */
    public boolean isEmpty1() {
        return top1 == -1;
    }

    /**
     * Checks if Stack 1 is full
     * @return true if full, false otherwise
     */
    public boolean isFull1() {
        return top1 + 1 == top2;
    }

    /**
     * Gets the current size of Stack 1
     * @return Number of elements in Stack 1
     */
    public int size1() {
        return top1 + 1;
    }

    /* Stack 2 Operations */

    /**
     * Pushes an element onto Stack 2
     * @param value The element to push
     * @throws StackOverflowError if Stack 2 is full
     */
    public void push2(Integer value) {
        if (isFull2()) {
            throw new StackOverflowError("Stack 2 is full");
        }
        arr[--top2] = value;
    }

    /**
     * Pops an element from Stack 2
     * @return The popped element
     * @throws EmptyStackException if Stack 2 is empty
     */
    public Integer pop2() {
        if (isEmpty2()) {
            throw new EmptyStackException();
        }
        return arr[top2++];
    }

    /**
     * Peeks at the top element of Stack 2
     * @return The top element
     * @throws EmptyStackException if Stack 2 is empty
     */
    public Integer peek2() {
        if (isEmpty2()) {
            throw new EmptyStackException();
        }
        return arr[top2];
    }

    /**
     * Checks if Stack 2 is empty
     * @return true if empty, false otherwise
     */
    public boolean isEmpty2() {
        return top2 == capacity;
    }

    /**
     * Checks if Stack 2 is full
     * @return true if full, false otherwise
     */
    public boolean isFull2() {
        return top2 - 1 == top1;
    }

    /**
     * Gets the current size of Stack 2
     * @return Number of elements in Stack 2
     */
    public int size2() {
        return capacity - top2;
    }
}
