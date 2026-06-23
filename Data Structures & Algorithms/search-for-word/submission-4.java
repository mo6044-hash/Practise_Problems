class Solution {
    private boolean isValidCell(char[][] grid, int row, int col) {
        return (row >= 0 && row < grid.length) && (col >= 0 && col < grid[0].length);
    }
    private boolean dfs(int index, String word, char[][] grid, int row, int col) {
        if (!isValidCell(grid, row, col)) return false;
        if (grid[row][col] == '#') return false;
        if (grid[row][col] != word.charAt(index)) return false;
        if (grid[row][col] == word.charAt(index) && index == word.length() - 1) return true;
        char c = grid[row][col];
        grid[row][col] = '#';
        //t
        if (dfs(index+1, word, grid, row-1, col)) return true;
        //b
        if (dfs(index+1, word, grid, row+1, col)) return true;
        //l
        if (dfs(index+1, word, grid, row, col-1)) return true;
        //r
        if (dfs(index+1, word, grid, row, col+1)) return true;
        grid[row][col] = c;
        return false;

    }

    public boolean exist(char[][] board, String word) {
        char firstLetter = word.charAt(0);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char c = board[i][j];
                if (c == firstLetter) {
                    if(dfs(0, word, board, i, j)) return true;
                }
            }
        }
        return false;
    }
}
