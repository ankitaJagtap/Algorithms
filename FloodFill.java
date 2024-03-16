class Solution {

    public void dfs(int[][] grid, int i, int j, int color, int ans) {
        if (i >= grid.length || j >= grid[0].length || i < 0 || j < 0 || grid[i][j] != ans)
            return;

        grid[i][j] = color;
        dfs(grid, i + 1, j, color, ans);
        dfs(grid, i - 1, j, color, ans);
        dfs(grid, i, j + 1, color, ans);
        dfs(grid, i, j - 1, color, ans);

    }

    public int[][] FloodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] != color) {
            int ans = image[sr][sc];
            dfs(image, sr, sc, color, ans);
        }
        return image;
    }
}