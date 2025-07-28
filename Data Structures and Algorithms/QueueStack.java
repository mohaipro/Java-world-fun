import java.util.Stack;

/**
 * Queue implementation using two stacks
 * 
 * This class implements a queue data structure using two stacks (Stack1 and Stack2).
 * It follows the classic two-stack queue approach where:
 * - Enqueue operations are O(1) time complexity
 * - Dequeue operations are O(n) in worst case but amortized O(1)
 */
public class QueueStack {
    // Stack1: Used for enqueue operations (push elements here)
    private Stack<String> st1;
    
    // Stack2: Used for dequeue operations (pop elements from here)
    private Stack<String> st2;

    /**
     * Constructor initializes both stacks
     */
    public QueueStack() {
        st1 = new Stack<String>();
        st2 = new Stack<String>();
    }
  
    /**
     * Returns the number of elements in Stack1
     * @return Size of Stack1
     */
    public int size1() {
        return st1.size();
    }
  
    /**
     * Returns the number of elements in Stack2
     * @return Size of Stack2
     */
    public int size2() {
        return st2.size();
    }
  
    /**
     * Returns the total number of elements in the queue
     * @return Combined size of both stacks
     */
    public int size() {
        return st1.size() + st2.size();
    }
  
    /**
     * Adds an element to the queue (enqueue operation)
     * @param str The string to be added to the queue
     * @throws NullPointerException if null value is passed
     */
    public void enqueue(String str) {
        if (str == null) {
            throw new NullPointerException("Cannot enqueue null value");
        }
        st1.push(str);
    }
  
    /**
     * Removes and returns the first element from the queue (dequeue operation)
     * @return The oldest element in the queue
     * @throws java.util.EmptyStackException if queue is empty
     */
    public String dequeue() {
        if (size() == 0) {
            throw new java.util.EmptyStackException();
        }
        
        // If Stack2 is empty, transfer all elements from Stack1
        if (st2.empty()) {
            while (!st1.empty()) {
                st2.push(st1.pop());
            }
        }
        
        return st2.pop();
    }
  
    /**
     * Peeks at the top element of Stack1 without removing it
     * @return Top element of Stack1
     * @throws java.util.EmptyStackException if Stack1 is empty
     */
    public String peek1() {
        return st1.peek();
    }
   
    /**
     * Peeks at the top element of Stack2 without removing it
     * @return Top element of Stack2
     * @throws java.util.EmptyStackException if Stack2 is empty
     */
    public String peek2() {
        return st2.peek();
    }
  
    /**
     * Checks if Stack1 is empty
     * @return true if Stack1 is empty, false otherwise
     */
    public boolean isEmpty1() {
        return st1.empty();
    }
    
    /**
     * Checks if Stack2 is empty
     * @return true if Stack2 is empty, false otherwise
     */
    public boolean isEmpty2() {
        return st2.empty();
    }
    
    /**
     * Checks if the entire queue is empty
     * @return true if both stacks are empty, false otherwise
     */
    public boolean isEmpty() {
        return st1.empty() && st2.empty();
    }
}

/**
 * Main class to demonstrate QueueStack usage
 */
public class Main {
    public static void main(String[] args) {
        QueueStack obj = new QueueStack();
        
        // Enqueue some names
        obj.enqueue("mohamed");
        obj.enqueue("mostafa"); 
        obj.enqueue("sara");
        
        // Dequeue and print the first name (FIFO order)
        String outValue = obj.dequeue();
        System.out.println(outValue); // Prints "mohamed"
        
        // Additional usage examples:
        System.out.println("Current queue size: " + obj.size()); // 2
        System.out.println("Next element: " + obj.peek2()); // "mostafa"
        System.out.println("Is Stack1 empty? " + obj.isEmpty1()); // true
    }
}
