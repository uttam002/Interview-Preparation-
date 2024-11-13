class Solution {
    public static int smallestSubWithSum(int x, int[] arr) {
        int n = arr.length;
        int minLength = Integer.MAX_VALUE; // To store the minimum length found
        int currentSum = 0; // Running sum of the current window
        int start = 0; // Left boundary of the window

        // Expand the window by moving the end pointer
        for (int end = 0; end < n; end++) {
            // Add current element to currentSum
            currentSum += arr[end];

            // While currentSum is greater than x, shrink the window from the left
            while (currentSum > x) {
                // Update minLength if the current window is smaller
                minLength = Math.min(minLength, end - start + 1);
                
                // Remove the element at 'start' from currentSum and move 'start' to the right
                currentSum -= arr[start];
                start++;
            }
        }

        // If minLength was updated, return it; otherwise, return 0 if no valid subarray exists
        return (minLength == Integer.MAX_VALUE) ? 0 : minLength;
    }
}
