class Solution {
    public String longestCommonPrefix(String arr[]) {
        if (arr == null || arr.length == 0) return "";
        String prefix = arr[0];
        for (String s : arr) {
            while (!s.startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }
}
