class Solution {
    private boolean isValidCell(int r, int c, int[][] grid) {
        return (r >= 0 && r < grid.length) && (c >= 0 && c < grid[0].length);
    }

    private int dfs(int row, int col, int[][] grid) {
        if (!isValidCell(row, col, grid)) return 0;
        if (grid[row][col] == 0) return 0;
        grid[row][col] = 0;
        return 1 + dfs(row+1, col, grid) +
                   dfs(row-1, col, grid) +
                   dfs(row, col+1, grid) +
                   dfs(row, col-1, grid);
    }

    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    max = Math.max(max, dfs(r, c, grid));
                }
            }
        }
        return max;
    }
}
