class Solution {
    private Boolean[][] memo;
    private boolean dfs(int index, int remaining, int[] nums) {
        if (index == nums.length || remaining < 0) return false;
        if (remaining == 0) {
            memo[index][remaining] = true;
            return true;
        }

        if (memo[index+1][remaining] != null) {
            return memo[index+1][remaining];
        } else {
            return (dfs(index+1, remaining-nums[index], nums) || dfs(index+1, remaining, nums));
        }


    }
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) return false;
        int remaining = sum / 2;
        memo = new Boolean[remaining+1][remaining+1];
        return dfs(0, remaining, nums);
    }
}
