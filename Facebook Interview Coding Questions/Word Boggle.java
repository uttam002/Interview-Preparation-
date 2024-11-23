class Solution {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEndOfWord = false;
    }

    // Helper function to insert words into the Trie
    private TrieNode buildTrie(String[] dictionary) {
        TrieNode root = new TrieNode();
        for (String word : dictionary) {
            TrieNode node = root;
            for (char c : word.toCharArray()) { // Preserve case sensitivity
                int index = Character.toLowerCase(c) - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }
                node = node.children[index];
            }
            node.isEndOfWord = true;
        }
        return root;
    }

    // Word Boggle function
    public String[] wordBoggle(char[][] board, String[] dictionary) {
        // Build Trie
        TrieNode root = buildTrie(dictionary);

        int rows = board.length, cols = board[0].length;
        Set<String> result = new HashSet<>();
        boolean[][] visited = new boolean[rows][cols];

        // Start backtracking from every cell
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                backtrack(board, visited, i, j, root, new StringBuilder(), result);
            }
        }

        // Convert result set to sorted array
        List<String> sortedResult = new ArrayList<>(result);
        Collections.sort(sortedResult);
        return sortedResult.toArray(new String[0]);
    }

    // Backtracking function
    private void backtrack(char[][] board, boolean[][] visited, int row, int col, TrieNode node, StringBuilder path, Set<String> result) {
        // Boundary and visited check
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length || visited[row][col]) {
            return;
        }

        char c = board[row][col];
        int index = Character.toLowerCase(c) - 'a';

        // Check if the current character exists in the trie
        if (index < 0 || index >= 26 || node.children[index] == null) {
            return;
        }

        // Update path and node
        path.append(c);
        node = node.children[index];

        // Check if it's a valid word
        if (node.isEndOfWord) {
            result.add(path.toString());
        }

        // Mark as visited
        visited[row][col] = true;

        // Explore all 8 directions
        int[] rowDir = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] colDir = {-1, 0, 1, -1, 1, -1, 0, 1};
        for (int d = 0; d < 8; d++) {
            backtrack(board, visited, row + rowDir[d], col + colDir[d], node, path, result);
        }

        // Unmark the cell and backtrack
        visited[row][col] = false;
        path.deleteCharAt(path.length() - 1);
    }
}
