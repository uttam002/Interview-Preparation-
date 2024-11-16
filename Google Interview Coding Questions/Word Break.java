class Solution {
    public static int wordBreak(int n, String s, ArrayList<String> dictionary) {
        // Convert the dictionary to a HashSet for quick lookups
        Set<String> wordSet = new HashSet<>(dictionary);

        // DP array to check if the string can be segmented up to index i
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true; // Empty string can always be segmented

        // Check each substring of s
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        // Return 1 if the string can be segmented, otherwise 0
        return dp[s.length()] ? 1 : 0;
    }

    public static void main(String[] args) {
        ArrayList<String> dictionary1 = new ArrayList<>(Arrays.asList("i", "like", "sam", "sung", "samsung", "mobile"));
        System.out.println(wordBreak(6, "ilike", dictionary1)); // Output: 1

        ArrayList<String> dictionary2 = new ArrayList<>(Arrays.asList("i", "like", "sam", "sung", "samsung", "mobile"));
        System.out.println(wordBreak(6, "ilikesamsung", dictionary2)); // Output: 1
    }
}
