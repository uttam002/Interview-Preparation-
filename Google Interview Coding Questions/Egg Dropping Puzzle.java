class Solution {
    // Function to find the minimum number of attempts needed.
    static int eggDrop(int n, int k) {
        // dp[i][j] represents the minimum number of attempts needed with i eggs and j floors.
        int[][] dp = new int[n + 1][k + 1];

        // Base cases
        for (int i = 1; i <= n; i++) {
            dp[i][0] = 0; // 0 floors, 0 attempts
            dp[i][1] = 1; // 1 floor, 1 attempt
        }
        for (int j = 1; j <= k; j++) {
            dp[1][j] = j; // 1 egg, j attempts (linear search)
        }

        // Fill the DP table for all eggs and floors
        for (int i = 2; i <= n; i++) {
            for (int j = 2; j <= k; j++) {
                dp[i][j] = Integer.MAX_VALUE;

                // Find the critical floor using binary search for optimization
                int low = 1, high = j;
                while (low <= high) {
                    int mid = (low + high) / 2;

                    int eggBreaks = dp[i - 1][mid - 1]; // Egg breaks
                    int eggDoesNotBreak = dp[i][j - mid]; // Egg doesn't break
                    int worstCase = 1 + Math.max(eggBreaks, eggDoesNotBreak);

                    dp[i][j] = Math.min(dp[i][j], worstCase);

                    // Adjust search range
                    if (eggBreaks > eggDoesNotBreak) {
                        high = mid - 1; // Look in lower floors
                    } else {
                        low = mid + 1; // Look in higher floors
                    }
                }
            }
        }

        return dp[n][k];
    }

    public static void main(String[] args) {
        System.out.println(eggDrop(1, 2)); // Output: 2
        System.out.println(eggDrop(2, 10)); // Output: 4
        System.out.println(eggDrop(10, 5)); // Output: 3
    }
}
