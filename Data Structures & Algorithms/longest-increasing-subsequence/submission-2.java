class Solution {
    HashMap<String, Integer> memo;
    private int dfs(int index, int prev, int[] nums) {
        if (index == nums.length) return 0;
        String key = index + ","+prev;

        if (memo.containsKey(key)) {
            return memo.get(key);
        } 
        if (nums[index] > prev) {
            int val = Math.max(1 + dfs(index+1, nums[index], nums), dfs(index+1, prev, nums));
            memo.put(key, val);
            return val;
        }
        int val = dfs(index+1, prev, nums);
        memo.put(key, val);
        return val;
    }
    public int lengthOfLIS(int[] nums) {
        memo = new HashMap<>();
        return dfs(0, Integer.MIN_VALUE, nums);
    }
}
