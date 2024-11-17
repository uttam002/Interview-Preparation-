class Solution {
    public int closedIslands(int[][] matrix, int N, int M) {
        boolean[][] visited = new boolean[N][M];
        int closedIslandCount = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (matrix[i][j] == 1 && !visited[i][j]) {
                    if (isClosedIsland(matrix, visited, i, j, N, M)) {
                        closedIslandCount++;
                    }
                }
            }
        }

        return closedIslandCount;
    }

    private boolean isClosedIsland(int[][] matrix, boolean[][] visited, int x, int y, int N, int M) {
        if (x < 0 || y < 0 || x >= N || y >= M) {
            return false; // Reached boundary, not closed
        }

        if (matrix[x][y] == 0 || visited[x][y]) {
            return true; // Water or already visited, continue
        }

        visited[x][y] = true; // Mark current cell as visited
        boolean top = isClosedIsland(matrix, visited, x - 1, y, N, M);
        boolean bottom = isClosedIsland(matrix, visited, x + 1, y, N, M);
        boolean left = isClosedIsland(matrix, visited, x, y - 1, N, M);
        boolean right = isClosedIsland(matrix, visited, x, y + 1, N, M);

        return top && bottom && left && right; // Island is closed if all directions return true
    }
}
