class Solution {
    public boolean isInterLeave(String A, String B, String C) {
        // If lengths don't add up, return false
        if (A.length() + B.length() != C.length()) {
            return false;
        }
        
        int m = A.length();
        int n = B.length();
        
        // Create a 2D DP table
        boolean[][] dp = new boolean[m + 1][n + 1];
        
        // Initialize the base case
        dp[0][0] = true;
        
        // Fill the DP table
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                // Check if we can take from A
                if (i > 0 && A.charAt(i - 1) == C.charAt(i + j - 1)) {
                    dp[i][j] |= dp[i - 1][j];
                }
                
                // Check if we can take from B
                if (j > 0 && B.charAt(j - 1) == C.charAt(i + j - 1)) {
                    dp[i][j] |= dp[i][j - 1];
                }
            }
        }
        
        // The answer is whether we can form C using all of A and B
        return dp[m][n];
    }
}
