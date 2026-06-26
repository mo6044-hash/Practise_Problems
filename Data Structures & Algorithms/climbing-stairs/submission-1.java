class Solution {
    public int climbStairs(int n) {
        if (n == 0 || n == 1) return 1;
        int prev = 1;
        int prevprev = 1;
        int curr = prev + prevprev;
        for (int i = 2; i <= n; i++) {
            curr = prev + prevprev;
            prevprev = prev;
            prev = curr;
        }
        return curr;
    }
}
