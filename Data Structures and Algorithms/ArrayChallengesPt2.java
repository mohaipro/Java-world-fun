import java.util.Arrays;

/**
 * Array Operations Utility Class
 * 
 * This class provides methods for:
 * 1. Finding frequency of a number in an array
 * 2. Rotating arrays (both with and without extra space)
 * 
 * @author YourName
 * @version 1.0
 * @since 2023-11-20
 */
public class ArrayOperations {

    public static void main(String[] args) {
        // Demonstration of array operations
        int[] array = {1, 2, 3, 4, 5};
        System.out.println("Original array: " + Arrays.toString(array));
        
        // Frequency demonstration
        int target = 3;
        System.out.println("Frequency of " + target + ": " + frequencyFinder(array, target));
        
        // Rotation demonstration
        int rotationAmount = 2;
        System.out.println("Rotated array (new copy): " + Arrays.toString(rotateArray(array, rotationAmount)));
        
        rotateArrayInPlace(array, 1);
        System.out.println("Array after in-place rotation: " + Arrays.toString(array));
    }

    /**
     * Counts the frequency of a number in an array
     * 
     * @param arr The input array to search
     * @param x The number to find frequency of
     * @return Count of occurrences of x in arr
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static int frequencyFinder(int[] arr, int x) {
        int counter = 0;
        for (int num : arr) {
            if (num == x) {
                counter++;
            }
        }
        return counter;
    }

    /**
     * Rotates array by x positions to the right using extra space
     * 
     * @param arr The input array to rotate
     * @param x Number of positions to rotate (must be < arr.length)
     * @return New rotated array
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static int[] rotateArray(int[] arr, int x) {
        if (x < 0 || x >= arr.length) {
            throw new IllegalArgumentException("Rotation amount must be between 0 and array length - 1");
        }
        
        int[] newArray = new int[arr.length];
        
        // Copy last x elements to beginning of new array
        System.arraycopy(arr, arr.length - x, newArray, 0, x);
        
        // Copy remaining elements
        System.arraycopy(arr, 0, newArray, x, arr.length - x);
        
        return newArray;
    }

    /**
     * Rotates array in-place using reversal algorithm (space optimized)
     * 
     * @param arr The array to rotate (modified in-place)
     * @param x Number of positions to rotate (must be < arr.length)
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static void rotateArrayInPlace(int[] arr, int x) {
        if (x < 0 || x >= arr.length) {
            throw new IllegalArgumentException("Rotation amount must be between 0 and array length - 1");
        }
        
        // Reverse entire array
        reverse(arr, 0, arr.length - 1);
        
        // Reverse first x elements
        reverse(arr, 0, x - 1);
        
        // Reverse remaining elements
        reverse(arr, x, arr.length - 1);
    }

    /**
     * Helper method to reverse array portion between indices
     * 
     * @param arr Array to modify
     * @param start Start index (inclusive)
     * @param end End index (inclusive)
     */
    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
