public class Main
{
    // Recursive binary search method
    // Searches for 'target' in 'arr' between indices 'left' and 'right'
    public static int binarySearchRecursive(int[] arr, int left, int right, int target) {
        // Calculate the middle index
        int mid = (left + right) / 2;
        // Base case: if search space is invalid or array is empty, return -1
        if (left > right || arr.length == 0) {
            return -1;
        }
        // Base case: if middle element is the target, return its index
        if (arr[mid] == target) {
            System.out.println("*");
            return mid;
        } else if (target < arr[mid]) {
            // Recursive case: search left half
            System.out.println("*");
            return binarySearchRecursive(arr, left, mid - 1, target);
        } else {
            // Recursive case: search right half
            System.out.println("*");
            return binarySearchRecursive(arr, mid + 1, right, target);
        }
    }
    
    // Iterative binary search method
    // Searches for 'target' in 'arr'
    public static int binarySearchIterative(int[] arr, int target) {
        // Set initial boundaries
        int left = 0;
        int right = arr.length - 1;
        // Loop until search space is valid
        while (left <= right) {
            // Calculate the middle index
            int mid = (left + right) / 2;
            // If target found, return index
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) {
                // Move right boundary left
                right = mid - 1;
            } else {
                // Move left boundary right
                left = mid + 1;
            }
        }
        // Target not found
        return -1;
    }
    
    public static void main(String[] args) {
        int[] arr = { 2, 5, 6, 8, 9, 10 };
        int target = 8; 
        int left = 0;
        int right = arr.length - 1;
        // Uncomment to use recursive version:
        // int index = binarySearchRecursive(arr, left, right, target);
        // Use iterative version:
        int index = binarySearchIterative(arr, target);
        System.out.println(index);
        if (index != -1) {
            System.out.println("Element found at index " + index);
        }
        else {
            System.out.println("Element not found in the array");
        }
    }
}
