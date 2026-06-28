class Solution {
    public int lengthOfLIS(int[] nums) {
        // for every new number, if it smaller than any number in the list, we replace 
        // with the first smaller number. if it is larger than all numbers, append
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (list.get(list.size()-1) < nums[i]) {
                list.add(nums[i]);
            } else {
                int index = Collections.binarySearch(list, nums[i]);
                if (index >= 0) {
                    list.set(index, nums[i]);
                } else {
                    // -i-1
                    //-(1+ -i -1) 
                    list.set(-(1+index), nums[i]);
                }
            }
        }
        return list.size();
    }
}
