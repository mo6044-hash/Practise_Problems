class Solution {
    private int[][] memo;

    private int dfs(String text1, String text2, int p1, int p2) {
        if (p1 == text1.length() || p2 == text2.length()) {
            return 0;
        }
        if (memo[p1][p2] != -1) {return memo[p1][p2];}else{
        if (text1.charAt(p1) == text2.charAt(p2)) {
            
            memo[p1][p2] =  1 + dfs(text1, text2, p1+1, p2+1);
            return memo[p1][p2];
        } else {
            memo[p1][p2] =  Math.max(dfs(text1, text2, p1+1, p2), dfs(text1, text2, p1, p2+1));
            return memo[p1][p2];
        }}
    }

    public int longestCommonSubsequence(String text1, String text2) {
        memo = new int[text1.length()][text2.length()];
        for (int[] row: memo) {
            Arrays.fill(row, -1);
        }
        return dfs(text1, text2, 0, 0);
    }
}
