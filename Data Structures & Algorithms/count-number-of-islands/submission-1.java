class Solution {
    private boolean isValidCell(char[][] grid, int r, int c) {
        return (r >= 0 && r < grid.length) && (c >= 0 && c < grid[0].length);
    }
    private void dfs(char[][] grid, int r, int c) {
        if (!isValidCell(grid, r, c)) return;
        if (grid[r][c] == '0') return;
        grid[r][c] = '0';
        //t
        dfs(grid, r-1, c);
        //b
        dfs(grid, r+1, c);
        //l
        dfs(grid, r, c-1);
        //r
        dfs(grid, r, c+1);
        return;
    }

    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
}
