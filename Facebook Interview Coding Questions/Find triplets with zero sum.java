class Solution {
    // Function to find triplets with zero sum.
    public boolean findTriplets(int[] arr) {
        int n = arr.length;

        // Sort the array
        java.util.Arrays.sort(arr);

        // Iterate through the array
        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;      // Start from the next element
            int right = n - 1;     // Start from the last element

            // Use two-pointer technique
            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];
                if (sum == 0) {
                    return true;   // Found a triplet with zero sum
                } else if (sum < 0) {
                    left++;        // Increase the sum by moving the left pointer
                } else {
                    right--;       // Decrease the sum by moving the right pointer
                }
            }
        }
        return false;              // No triplet found
    }

}
