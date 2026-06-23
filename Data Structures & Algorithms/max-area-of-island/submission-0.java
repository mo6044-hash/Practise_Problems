class Solution {
    private boolean isValidCell(int r, int c, int[][] grid) {
        return (r >= 0 && r < grid.length) && (c >= 0 && c < grid[0].length);
    }

    private int dfs(int row, int col, int curr, int[][] grid) {
        if (!isValidCell(row, col, grid)) return curr;
        if (grid[row][col] == 0) return curr;
        curr += 1;
        grid[row][col] = 0;
        //top
        curr = dfs(row-1, col, curr, grid);
        //bottom
        curr = dfs(row+1, col, curr, grid);
        //right
        curr = dfs(row, col+1, curr, grid);
        //left
        curr = dfs(row, col-1, curr, grid);
        return curr;
    }

    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    int curr = 0;
                    max = Math.max(max, dfs(r, c, curr, grid));
                }
            }
        }
        return max;
    }
}
