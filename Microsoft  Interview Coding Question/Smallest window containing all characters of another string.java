class Solution {
    // Function to find the smallest window in the string s1 consisting
    // of all the characters of string s2.
    public static String smallestWindow(String s1, String s2) {
        // Lengths of input strings
        int sLen = s1.length();
        int tLen = s2.length();

        // If s1 is shorter than s2, no possible window
        if (sLen < tLen) {
            return "";
        }

        // Arrays to store the count of characters in s2
        int[] required = new int[256]; // ASCII character set
        int[] current = new int[256];

        // Populate the required array based on characters in s2
        for (int i = 0; i < tLen; i++) {
            required[s2.charAt(i)]++;
        }

        // Variables for the sliding window
        int left = 0, right = 0;
        int minLen = sLen + 1, startIdx = 0, count = 0;

        // Sliding window algorithm
        while (right < sLen) {
            // Expand the window by moving the right pointer
            if (required[s1.charAt(right)] > 0) {
                current[s1.charAt(right)]++;
                if (current[s1.charAt(right)] <= required[s1.charAt(right)]) {
                    count++;
                }
            }

            // Contract the window by moving the left pointer
            while (count == tLen) {
                // Update the minimum window substring
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    startIdx = left;
                }

                // Shrink the window
                if (required[s1.charAt(left)] > 0) {
                    current[s1.charAt(left)]--;
                    if (current[s1.charAt(left)] < required[s1.charAt(left)]) {
                        count--;
                    }
                }

                // Move the left pointer
                left++;
            }

            // Move the right pointer to expand the window
            right++;
        }

        // If no valid window found
        if (minLen == sLen + 1) {
            return "";
        }

        // Return the result substring
        return s1.substring(startIdx, startIdx + minLen);
    }
}
