class Solution {
    public List<String> generate_binary_string(String s) {
        List<String> result = new ArrayList<>();
        generate(s.toCharArray(), 0, result);
        return result;
    }
    
    private void generate(char[] s, int index, List<String> result) {
        if (index == s.length) {
            result.add(new String(s));
            return;
        }
        if (s[index] == '?') {
            s[index] = '0';
            generate(s, index + 1, result);
            s[index] = '1';
            generate(s, index + 1, result);
            s[index] = '?';  // backtrack
        } else {
            generate(s, index + 1, result);
        }
    }
}
