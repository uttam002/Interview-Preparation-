class Solution {
    public int countWays(String s) {
        int n = s.length();
        if (s.charAt(0) == '0') return 0; // A string starting with '0' is invalid
        
        int[] dp = new int[n + 1];
        dp[0] = 1; // Base case: Empty string has one way to decode
        dp[1] = 1; // Single character (non-'0') has one way to decode
        
        for (int i = 2; i <= n; i++) {
            // Check if the current character can be decoded
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }
            // Check if the last two characters can be decoded
            int twoDigit = Integer.parseInt(s.substring(i - 2, i));
            if (twoDigit >= 10 && twoDigit <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        
        return dp[n];
    }
}
