class Solution {
    private boolean dfs(int index, int remaining, int[] nums) {
        if (index == nums.length || remaining < 0) return false;
        if (remaining == 0) return true;

        return (dfs(index + 1, remaining-nums[index], nums) || dfs(index+1, remaining, nums)); 


    }
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) return false;
        int remaining = sum / 2;
        return dfs(0, remaining, nums);
    }
}
