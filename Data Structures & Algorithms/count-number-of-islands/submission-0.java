class Solution {
    private boolean isValidCell(char[][] grid, int r, int c) {
        return (r >= 0 && r < grid.length) && (c >= 0 && c < grid[0].length);
    }
    private boolean dfs(char[][] grid, int r, int c) {
        if (!isValidCell(grid, r, c)) return false;
        if (grid[r][c] == '0') return false;
        grid[r][c] = '0';
        //t
        if (dfs(grid, r-1, c)) return true;
        //b
        if (dfs(grid, r+1, c)) return true;
        //l
        if (dfs(grid, r, c-1)) return true;
        //r
        if (dfs(grid, r, c+1)) return true;
        return false;
    }

    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }
}
