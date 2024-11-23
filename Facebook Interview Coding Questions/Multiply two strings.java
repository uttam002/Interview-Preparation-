class Solution {
    public String multiplyStrings(String s1, String s2) {
        // Handle negative numbers and determine the result's sign
        boolean isNegative = false;
        if (s1.charAt(0) == '-') {
            isNegative = !isNegative;
            s1 = s1.substring(1);
        }
        if (s2.charAt(0) == '-') {
            isNegative = !isNegative;
            s2 = s2.substring(1);
        }
        
        // Remove leading zeros
        s1 = s1.replaceFirst("^0+", "");
        s2 = s2.replaceFirst("^0+", "");
        
        // Edge case: if any string is empty after removing leading zeros
        if (s1.length() == 0 || s2.length() == 0) {
            return "0";
        }
        
        int n = s1.length();
        int m = s2.length();
        int[] result = new int[n + m]; // Maximum possible size of the result
        
        // Perform multiplication digit by digit
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                int mul = (s1.charAt(i) - '0') * (s2.charAt(j) - '0');
                int sum = mul + result[i + j + 1]; // Add to existing value in result array
                result[i + j + 1] = sum % 10; // Current digit
                result[i + j] += sum / 10; // Carry
            }
        }
        
        // Convert result array to string
        StringBuilder sb = new StringBuilder();
        for (int num : result) {
            if (sb.length() != 0 || num != 0) { // Skip leading zeros
                sb.append(num);
            }
        }
        
        // If result is empty, return "0"
        if (sb.length() == 0) {
            return "0";
        }
        
        // Add sign if negative
        if (isNegative) {
            sb.insert(0, '-');
        }
        
        return sb.toString();
    }
}
