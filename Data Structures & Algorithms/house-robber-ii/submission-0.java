class Solution {
    private int rob1(int[] houses) {
        int[] rob = new int[houses.length];
        rob[0] = houses[0];
        if (houses.length == 1) return rob[0];
        rob[1] = Math.max(houses[0], houses[1]);

        for (int i = 2; i < houses.length; i++) {
            rob[i] = Math.max(rob[i-2] + houses[i], rob[i-1]);
        }
        return rob[houses.length-1];
    }
    public int rob(int[] nums) {
        if (nums.length == 1) return rob1(nums);
        int n = nums.length;

        // with 0
        int[] with0 = new int[nums.length - 1];
        for (int i = 0; i < nums.length - 1; i++) {
            with0[i] = nums[i];
        }

        // without0
        int[] without0 = new int[nums.length - 1];
        for (int j = 1; j < nums.length; j++) {
            without0[j - 1] = nums[j];
        }
        return Math.max(rob1(with0), rob1(without0));
    }
}
