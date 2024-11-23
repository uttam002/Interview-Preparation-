class Solution {
    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        int sum = 0, start = 0;
        for (int end = 0; end < arr.length; end++) {
            sum += arr[end];
            while (sum > target) sum -= arr[start++];
            if (sum == target) return new ArrayList<>(List.of(start + 1, end + 1));
        }
        return new ArrayList<>(List.of(-1));
    }
}
