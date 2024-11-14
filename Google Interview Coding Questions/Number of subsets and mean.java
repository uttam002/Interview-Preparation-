class Solution {
    static final int MOD = 1_000_000_007;
    
    static int[] numOfSubsets(int[] Arr , int N) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        long minCount = 0, maxCount = 0;
        
        for (int num : Arr) {
            if (num < min) {
                min = num;
                minCount = 1;
            } else if (num == min) {
                minCount++;
            }
            if (num > max) {
                max = num;
                maxCount = 1;
            } else if (num == max) {
                maxCount++;
            }
        }
        
        long maxSubsets = power(2, maxCount) - 1;
        long minSubsets = power(2, minCount) - 1;
        
        return new int[]{(int)(maxSubsets % MOD), (int)(minSubsets % MOD)};
    }
    
    static long power(long base, long exp) {
        long result = 1;
        while (exp > 0) {
            if ((exp & 1) != 0) result = (result * base) % MOD;
            base = (base * base) % MOD;
            exp >>= 1;
        }
        return result;
    }
}
