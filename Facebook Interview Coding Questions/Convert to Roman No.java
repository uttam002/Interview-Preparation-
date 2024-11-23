class Solution {
    String convertToRoman(int n) {
        // Define Roman symbols and corresponding values
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        
        StringBuilder roman = new StringBuilder();
        
        // Traverse through all values
        for (int i = 0; i < values.length; i++) {
            // While n is greater than or equal to the current value
            while (n >= values[i]) {
                roman.append(symbols[i]); // Append the corresponding symbol
                n -= values[i]; // Subtract the value from n
            }
        }
        
        return roman.toString(); // Return the Roman numeral representation
    }
}
