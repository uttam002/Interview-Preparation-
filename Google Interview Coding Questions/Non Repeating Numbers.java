class Solution {
    public List<Integer> singleNumber(int[] arr) {
        int xor = 0;
        for (int num : arr) xor ^= num;
        int bit = xor & -xor, a = 0, b = 0;
        for (int num : arr) {
            if ((num & bit) == 0) a ^= num;
            else b ^= num;
        }
        return a < b ? List.of(a, b) : List.of(b, a);
    }
}
