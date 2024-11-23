class GfG {
    boolean iskPalindrome(String s, int k) {
        int n = s.length();
        int[][] memo = new int[n][n];
        return (n - lps(s, 0, n - 1, memo)) <= k;
    }
    
    int lps(String s, int i, int j, int[][] memo) {
        if (i >= j) return (i == j) ? 1 : 0;
        if (memo[i][j] != 0) return memo[i][j];
        if (s.charAt(i) == s.charAt(j)) {
            memo[i][j] = 2 + lps(s, i + 1, j - 1, memo);
        } else {
            memo[i][j] = Math.max(lps(s, i + 1, j, memo), lps(s, i, j - 1, memo));
        }
        return memo[i][j];
    }
}
