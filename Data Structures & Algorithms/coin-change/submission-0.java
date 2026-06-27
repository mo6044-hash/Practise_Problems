class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] am = new int[amount+1];
        for (int j = 0; j < am.length; j++) {
            am[j] = amount + 1;
        }
        am[0] = 0;

        for (int i = 1; i < amount + 1; i++) {
            int candidate = amount + 1;
            for (int coin : coins) {
                //am[i] = min(am[i], 1+am[i-coin])
                if (i-coin >= 0) {
                    candidate = Math.min(candidate, am[i-coin]+1);
                }
            }
            am[i] = Math.min(candidate, am[i]);
        }
        if (am[amount] > amount) return -1;
        return am[amount];
    }
}
