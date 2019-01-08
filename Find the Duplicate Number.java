class Solution {
    public int findDuplicate(int[] nums) {
        if(nums == null || nums.length <= 1) return -1;
        int slow = nums[0]; // be careful about the initialization
        int fast = nums[nums[0]]; // be careful about the initialization
        while(nums[slow] != nums[fast]){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        slow = 0;
        while(nums[slow] != nums[fast]){
            slow = nums[slow];
            fast = nums[fast];
        }
        return nums[slow];
    }
}