class Solution {
    static String lookandsay(int n) {
        // Start with the base case
        String result = "1";

        // Generate terms iteratively up to the nth term
        for (int i = 2; i <= n; i++) {
            result = getNextSequence(result);
        }

        return result;
    }

    // Function to generate the next sequence based on the current sequence
    private static String getNextSequence(String current) {
        StringBuilder next = new StringBuilder();
        int count = 1;

        // Traverse the current sequence
        for (int i = 1; i < current.length(); i++) {
            // If the current digit is the same as the previous, increment the count
            if (current.charAt(i) == current.charAt(i - 1)) {
                count++;
            } else {
                // Otherwise, append the count and the digit to the result
                next.append(count).append(current.charAt(i - 1));
                count = 1; // Reset the count for the new digit
            }
        }

        // Append the last group
        next.append(count).append(current.charAt(current.length() - 1));

        return next.toString();
    }
}
