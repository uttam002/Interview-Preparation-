class Solution {
    public int maximumProfit(int[] prices) {
        // Initialize profit
        int profit = 0;
        
        // Traverse the price array
        for (int i = 1; i < prices.length; i++) {
            // If there is a profit opportunity, add it
            if (prices[i] > prices[i - 1]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        
        return profit;
    }
}
