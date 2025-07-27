import java.util.Arrays;

/**
 * Array Reversal Utilities
 * 
 * This class provides multiple implementations for reversing arrays in Java,
 * demonstrating different approaches with varying time/space complexity tradeoffs.
 * 
 * @author YourName
 * @version 1.0
 * @since 2023-11-20
 */
public class ArrayReverser {

    public static void main(String[] args) {
        // Demonstration of array reversal methods
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println("Original array >> " + Arrays.toString(arr));
        
        // Test different reversal methods (uncomment to test)
        // int[] reversed = reverseArray(arr);
        // reverseInPlace1(arr);
        // reverseInPlace2(arr);
        reverseInPlace3(arr);
        
        System.out.println("Reversed array >> " + Arrays.toString(arr));
    }

    /**
     * Reverses an array by creating a new reversed copy.
     * 
     * @param arr The input array to be reversed
     * @return A new array with elements in reverse order
     * 
     * Time Complexity: O(n) - Linear time
     * Space Complexity: O(n) - Additional array of same size needed
     */
    public static int[] reverseArray(int[] arr) {
        int[] arrRev = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            arrRev[arr.length - 1 - i] = arr[i];
        }
        return arrRev;
    }

    /**
     * Reverses an array in-place using a bubble-sort like approach.
     * Note: This is intentionally inefficient for educational purposes.
     * 
     * @param arr The array to be reversed (modified directly)
     * 
     * Time Complexity: O(n²) - Quadratic time (nested loops)
     * Space Complexity: O(1) - Constant space (in-place modification)
     */
    public static void reverseInPlace1(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
            }
        }
    }

    /**
     * Reverses an array in-place using the two-pointer technique.
     * This is one of the most efficient approaches.
     * 
     * @param arr The array to be reversed (modified directly)
     * 
     * Time Complexity: O(n) - Linear time (single pass)
     * Space Complexity: O(1) - Constant space (in-place modification)
     */
    public static void reverseInPlace2(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    /**
     * Reverses an array in-place using a single loop with midpoint calculation.
     * This is equally efficient as reverseInPlace2 but uses different indexing.
     * 
     * @param arr The array to be reversed (modified directly)
     * 
     * Time Complexity: O(n) - Linear time (single pass)
     * Space Complexity: O(1) - Constant space (in-place modification)
     */
    public static void reverseInPlace3(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[len - i - 1];
            arr[len - i - 1] = temp;
        }
    }
}
