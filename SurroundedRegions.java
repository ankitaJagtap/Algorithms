class Solution {
    public void dfs(char[][] grid, int i, int j, int m, int n) {
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] != 'O')
            return;

        grid[i][j] = '@';
        dfs(grid, i + 1, j, m, n);
        dfs(grid, i - 1, j, m, n);
        dfs(grid, i, j + 1, m, n);
        dfs(grid, i, j - 1, m, n);

    }

    public void solve(char[][] board) {
        if (board.length == 0)
            return;
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[0][j] == 'O') {
                    dfs(board, 0, j, m, n);
                } else if (board[m - 1][j] == 'O') {
                    dfs(board, m - 1, j, m, n);
                } else if (board[i][0] == 'O') {
                    dfs(board, i, 0, m, n);
                } else if (board[i][n - 1] == 'O') {
                    dfs(board, i, n - 1, m, n);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '@') {
                    board[i][j] = 'O';
                }
            }
        }
        return;
    }
}