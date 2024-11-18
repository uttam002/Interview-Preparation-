class Solution {
    // Function to rotate an array by d elements in counter-clockwise direction.
    static void rotateArr(int arr[], int d) {
        int n = arr.length;

        // Handle cases where d > n
        d = d % n;

        if (d == 0) return; // No rotation needed

        // Step 1: Reverse the first d elements
        reverse(arr, 0, d - 1);

        // Step 2: Reverse the remaining n - d elements
        reverse(arr, d, n - 1);

        // Step 3: Reverse the entire array
        reverse(arr, 0, n - 1);
    }

    // Helper function to reverse elements in an array between indices start and end
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
