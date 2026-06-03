class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> sum = new HashMap<>();
        int[] ans = new int[2];

        for (int i = 0; i < nums.length; i++) {
            int x = target - nums[i];
            if (sum.containsKey(x)) {
                ans[0] = sum.get(x);
                ans[1] = i;
            } else {
                sum.put(nums[i], i);
            }
        }
        return ans;
    }
}
