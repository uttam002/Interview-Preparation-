class Solution {
    boolean areKAnagrams(String s1, String s2, int k) {
        if (s1.length() != s2.length()) return false;
        int[] count = new int[26];
        for (char c : s1.toCharArray()) count[c - 'a']++;
        for (char c : s2.toCharArray()) count[c - 'a']--;
        int changesNeeded = 0;
        for (int i : count) if (i > 0) changesNeeded += i;
        return changesNeeded <= k;
    }
}
