class Solution {
    static int maxIndexDiff(int[] arr) {
        int n = arr.length, maxDiff = 0;
        int[] leftMin = new int[n], rightMax = new int[n];
        leftMin[0] = arr[0];
        for (int i = 1; i < n; i++) leftMin[i] = Math.min(leftMin[i - 1], arr[i]);
        rightMax[n - 1] = arr[n - 1];
        for (int j = n - 2; j >= 0; j--) rightMax[j] = Math.max(rightMax[j + 1], arr[j]);
        for (int i = 0, j = 0; i < n && j < n;) {
            if (leftMin[i] <= rightMax[j]) { maxDiff = Math.max(maxDiff, j - i); j++; }
            else i++;
        }
        return maxDiff;
    }
}
