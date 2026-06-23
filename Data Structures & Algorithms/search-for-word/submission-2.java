class Solution {
    private boolean isValidCell(char[][] grid, int row, int col) {
        return (row >= 0 && row < grid.length) && (col >= 0 && col < grid[0].length);
    }
    private boolean dfs(int index, String word, int row, int col, char[][] grid) {
        if (index >= word.length()) return false;
        if (index == word.length() - 1) return true;
        char nextC = word.charAt(index + 1);
        

        //top
        if (isValidCell(grid, row-1, col) && grid[row-1][col] == nextC && grid[row-1][col] != '#'){
            char tempT = grid[row-1][col];
            grid[row-1][col] = '#';
            if(dfs(index + 1, word, row-1, col, grid)) return true;
            else grid[row-1][col] = tempT;
        }
        //bottom
        if (isValidCell(grid, row+1, col) && grid[row+1][col] == nextC && grid[row+1][col] != '#'){
            char tempB = grid[row+1][col];
            grid[row+1][col] = '#';
            if(dfs(index + 1, word, row+1, col, grid)) return true;
            else grid[row+1][col] = tempB;
        }
        //left
        if (isValidCell(grid, row, col-1) && grid[row][col-1] == nextC && grid[row][col-1] != '#'){
            char tempL = grid[row][col-1];
            grid[row][col-1] = '#';
            if(dfs(index + 1, word, row, col-1, grid)) return true;
            else grid[row][col-1] = tempL;
        }
        //right
        if (isValidCell(grid, row, col+1) && grid[row][col+1] == nextC && grid[row][col+1] != '#'){
            char tempR = grid[row][col+1];
            grid[row][col+1] = '#';
            if (dfs(index + 1, word, row, col+1, grid)) return true;
            else grid[row][col+1] = tempR;
        } 
        return false;
    }

    public boolean exist(char[][] board, String word) {
        char firstLetter = word.charAt(0);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char c = board[i][j];
                if (c == firstLetter) {
                    
                    int index = 0;
                    char temp = board[i][j];
                    board[i][j] = '#';
                    if (dfs(0, word, i, j, board)) return true;
                    else board[i][j] = temp;
                }
                
            }
        }
        return false;
    }
}
