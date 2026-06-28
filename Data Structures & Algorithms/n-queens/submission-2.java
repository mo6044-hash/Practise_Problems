class Solution {
    HashSet<Integer> cols = new HashSet<>();
    HashSet<Integer> diag1 = new HashSet<>(); // row + col
    HashSet<Integer> diag2 = new HashSet<>(); // row - col

    List<List<String>> result = new ArrayList<>();
    char[][] board;
    int n;

    private void saveBoard() {
        List<String> sol = new ArrayList<>();
        for (char[] r: board) {
            sol.add(new String(r));
        }
        result.add(sol);
        return;
    }

    private void dfs(int row) {
        if (row == n) {
            saveBoard();
            return;
        }

        for (int col = 0; col < n; col++) {
            if (diag1.contains(row + col)) continue;
            if (diag2.contains(row - col)) continue;
            if (cols.contains(col)) continue;

            board[row][col] = 'Q';
            diag1.add(row+col);
            diag2.add(row-col);
            cols.add(col);

            dfs(row+1);

            board[row][col] = '.';
            diag1.remove(row+col);
            diag2.remove(row-col);
            cols.remove(col);
        }
    }

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        board = new char[n][n];

        for (char[] row: board) {
            Arrays.fill(row, '.');
        }

        dfs(0);
        return result;
    }
}
