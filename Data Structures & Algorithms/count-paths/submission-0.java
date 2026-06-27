class Solution {
    private boolean isValidCell(int row, int col, int[][] grid) {
        return (row >= 0 && row < grid.length) && (col >= 0 && col < grid[0].length);
    }
    private int uPaths(int[][] grid, int row, int col) {
        if (row == 0 && col == 0) {
            grid[0][0] = 1;
            return 1;
        }
        if (!isValidCell(row, col, grid)) return 0;
        if (grid[row][col] != -1) return grid[row][col];
        grid[row][col] = uPaths(grid, row, col-1) + uPaths(grid, row-1, col);
        return grid[row][col];

    }
    public int uniquePaths(int m, int n) {
        int[][] grid = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = -1;
            }
        }
        return uPaths(grid, m-1, n-1);
    }
}
