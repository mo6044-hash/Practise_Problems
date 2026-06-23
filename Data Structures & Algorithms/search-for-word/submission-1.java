class Solution {
    private boolean isValidCell(char[][] grid, int row, int col) {
        return (row >= 0 && row < grid.length) && (col >= 0 && col < grid[0].length);
    }
    private boolean dfs(int index, String word, int row, int col, char[][] grid, char[][] tempGrid) {
        if (index >= word.length()) return false;
        if (index == word.length() - 1) return true;
        char nextC = word.charAt(index + 1);
        

        //top
        if (isValidCell(grid, row-1, col) && grid[row-1][col] == nextC && tempGrid[row-1][col] != '#'){
            tempGrid[row-1][col] = '#';
            if(dfs(index + 1, word, row-1, col, grid, tempGrid)) return true;
            else tempGrid[row-1][col] = grid[row-1][col];
        }
        //bottom
        if (isValidCell(grid, row+1, col) && grid[row+1][col] == nextC && tempGrid[row+1][col] != '#'){
            tempGrid[row+1][col] = '#';
            if(dfs(index + 1, word, row+1, col, grid, tempGrid)) return true;
            else tempGrid[row+1][col] = grid[row+1][col];
        }
        //left
        if (isValidCell(grid, row, col-1) && grid[row][col-1] == nextC && tempGrid[row][col-1] != '#'){
            tempGrid[row][col-1] = '#';
            if(dfs(index + 1, word, row, col-1, grid, tempGrid)) return true;
            else tempGrid[row][col-1] = grid[row][col-1];
        }
        //right
        if (isValidCell(grid, row, col+1) && grid[row][col+1] == nextC && tempGrid[row][col+1] != '#'){
            tempGrid[row][col+1] = '#';
            if (dfs(index + 1, word, row, col+1, grid, tempGrid)) return true;
            else tempGrid[row][col+1] = grid[row][col+1];
        } 
        return false;
    }

    public boolean exist(char[][] board, String word) {
        char firstLetter = word.charAt(0);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char c = board[i][j];
                if (c == firstLetter) {
                    char[][] tempGrid = new char[board.length][board[0].length];
                    for (int r = 0; r < board.length; r++) {
                        for (int co = 0; co < board[0].length; co++) {
                            tempGrid[r][co] = board[r][co];
                        }
                    }
                    int index = 0;
                    tempGrid[i][j] = '#';
                    if (dfs(0, word, i, j, board, tempGrid)) return true;
                }
                
            }
        }
        return false;
    }
}
