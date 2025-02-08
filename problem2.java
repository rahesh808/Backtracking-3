class Solution1 {
    int m;
    int n;
    int[][] dirs;
    boolean[][] grid;

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) {
            return false;
        }
        m = board.length;
        n = board[0].length;
        grid = new boolean[m][n];
        dirs = new int[][] { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int row, int col, String word, int index) {
        // base
        if (index == word.length()) {
            return true;
        }
        if (row < 0 || row == m || col < 0 || col == n || grid[row][col] == true) {
            return false;
        }

        // logic
        if (board[row][col] != word.charAt(index)) {
            return false;
        }
            // action
            grid[row][col] = true;
            // recurse
            for (int[] dir : dirs) {
                int nr = row + dir[0];
                int nc = col + dir[1];
                if(dfs(board, nr, nc, word, index + 1)) {
                    return true;
                }
            }
            // backtrack
            grid[row][col] = false;
        
        return false;
    }
}