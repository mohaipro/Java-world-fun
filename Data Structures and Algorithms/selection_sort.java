import java.util.Arrays;

public class SelectionSort
{
    // Implements the selection sort algorithm to sort an integer array in ascending order
    public static void selectionSort(int[] arr) {
        int size = arr.length; // Get the size of the array
        // Loop through each element except the last one
        for (int i = 0; i < size - 1; i++) {
            int currentMinimumIndex = i; // Assume the current position has the minimum value
            // Find the index of the smallest value in the unsorted part
            for (int j = i + 1; j < size; j++) {
                if (arr[j] < arr[currentMinimumIndex]) {
                    currentMinimumIndex = j;
                }
            }
            // Swap the found minimum value with the value at position i
            int temp = arr[i];
            arr[i] = arr[currentMinimumIndex];
            arr[currentMinimumIndex] = temp;
            System.out.println("sorting.."); // Print progress
        }
    }
    
    public static void main(String[] args) {
        int[] array = { 2, 7, 1, 16, 4, 0 }; // Example array to sort
        System.out.println(Arrays.toString(array)); // Print original array
        selectionSort(array); // Call the selection sort algorithm
        System.out.println(Arrays.toString(array)); // Print sorted array
    }
}
