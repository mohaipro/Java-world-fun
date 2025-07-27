import java.util.*;

/**
 * Missing Number Finder
 * 
 * This program demonstrates two approaches to find the missing number
 * in an array containing numbers from 1 to N with one number missing.
 */
public class Main {
    public static void main(String[] args) {
        // Test array with numbers 1-5 (4 is missing)
        int[] arr = {5, 1, 2, 3};
        
        // Find missing number using brute-force approach
        int num = missingNum(arr, 5);
        System.out.println("Brute-force result: " + num);
        
        // Find missing number using mathematical approach
        int NUM = missingNum2(arr, 5);
        System.out.println("Mathematical approach result: " + NUM);
    }

    /**
     * Finds the missing number using a nested loop approach (brute-force)
     * 
     * @param arr The input array (should contain numbers 1 to N with one missing)
     * @param N The upper bound of the number sequence
     * @return The missing number, or -1 if no number is missing
     * 
     * Time Complexity: O(n²) - Nested loops make this inefficient for large arrays
     * Space Complexity: O(1) - Uses constant extra space
     * 
     * Note: This is a demonstration of a less efficient approach
     */
    public static int missingNum(int[] arr, int N) {
        int flag = -1; // Initialize with -1 (indicates no missing number found)
        
        // Check each number from 1 to N
        for (int i = 1; i <= N; i++) {
            int count = 0;
            
            // Check if current number exists in array
            for (int j = 0; j < arr.length; j++) {
                if (i == arr[j]) {
                    break; // Number found, move to next
                }
                count++;
            }
            
            // If number wasn't found in array
            if (count == arr.length) {
                flag = i;
            }
        }
        return flag;
    }

    /**
     * Finds the missing number using the sum of first N natural numbers
     * 
     * @param arr The input array (should contain numbers 1 to N with one missing)
     * @param N The upper bound of the number sequence
     * @return The missing number (will be 0 if no number is missing)
     * 
     * Time Complexity: O(n) - Single pass through array makes this efficient
     * Space Complexity: O(1) - Uses constant extra space
     * 
     * Note: This is the recommended approach for most cases
     */
    public static int missingNum2(int[] arr, int N) {
        // Calculate sum of first N natural numbers: S = N(N+1)/2
        int totSum = N * (N + 1) / 2;
        int expectSum = 0;
        
        // Calculate sum of array elements
        for (int num : arr) {
            expectSum += num;
        }
        
        // The difference is the missing number
        return totSum - expectSum;
    }
}
