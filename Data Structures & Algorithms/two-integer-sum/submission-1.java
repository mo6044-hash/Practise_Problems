class Solution {
    public int[] twoSum(int[] nums, int target) {
       HashMap<Integer, Integer> position = new HashMap<>();

       for (int i = 0; i < nums.length; i++) {
        int x = target - nums[i];

        if (position.containsKey(x)) {
            int k = position.get(x);
            int[] ans = new int[2];
            ans[0] = k;
            ans[1] = i;
            return ans;
        }
        else position.put(nums[i], i);
       } 

       return new int[]{1, 2};
    }
}
