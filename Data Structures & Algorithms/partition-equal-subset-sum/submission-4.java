class Solution {
    private Boolean[][] memo;
    private boolean dfs(int index, int remaining, int[] nums) {
        if (index == nums.length || remaining < 0) return false;
        if (remaining == 0) {
            memo[index][remaining] = true;
            return true;
        }

        if (memo[index][remaining] != null) {
            return memo[index][remaining];
        } else {
            memo[index][remaining] = (dfs(index+1, remaining-nums[index], nums) || dfs(index+1, remaining, nums));
            return memo[index][remaining];
        }


    }
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) return false;
        int remaining = sum / 2;
        memo = new Boolean[nums.length][remaining+1];
        return dfs(0, remaining, nums);
    }
}
