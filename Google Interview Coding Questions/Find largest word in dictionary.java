// User function Template for Java
class Solution {
    static String findLongestWord(String s, List<String> d) {
        // Sort dictionary first by length (descending) and then lexicographically (ascending)
        d.sort((word1, word2) -> {
            if (word1.length() == word2.length()) {
                return word1.compareTo(word2);
            }
            return word2.length() - word1.length();  // Sort by descending length
        });

        // Check each word if it can be formed by deleting characters from s
        for (String word : d) {
            if (isSubsequence(s, word)) {
                return word;  // Return the first valid word found
            }
        }

        return "";  // If no valid word is found, return an empty string
    }

    // Helper function to check if 'word' is a subsequence of 's'
    private static boolean isSubsequence(String s, String word) {
        int i = 0;  // Pointer for string s
        int j = 0;  // Pointer for word

        while (i < s.length() && j < word.length()) {
            if (s.charAt(i) == word.charAt(j)) {
                j++;  // Move pointer of word if characters match
            }
            i++;  // Always move pointer of s
        }

        // If j has reached the end of word, it means word is a subsequence of s
        return j == word.length();
    }
}
