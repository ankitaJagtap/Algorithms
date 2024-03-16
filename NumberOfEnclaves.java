class Solution {

    public void dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] != 1)
            return;

        grid[i][j] = 2;
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }

    public int numEnclaves(int[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[0][j] == 1) {
                    dfs(grid, 0, j);
                } else if (grid[m - 1][j] == 1) {
                    dfs(grid, m - 1, j);
                } else if (grid[i][0] == 1) {
                    dfs(grid, i, 0);
                } else if (grid[i][n - 1] == 1) {
                    dfs(grid, i, n - 1);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    count++;
                }
            }
        }
        return count;
    }
}