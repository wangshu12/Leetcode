class Solution {
    public int search(int[] nums, int target) {
        //edge case
        if(nums == null || nums.length == 0) return -1;
        //find the index where the rotation happens
        int i = 0;
        int j = nums.length - 1;
        while(i < j){
            int mid = (i + j) / 2;
            if(target == nums[mid]) return mid;
            if(nums[mid] < nums[j]) j = mid;
            else i = mid + 1;
        }
        int rot = i;
        if(target >= nums[rot] && target <= nums[nums.length - 1]) return bns(nums, rot, nums.length - 1, target);
        else return bns(nums, 0, rot, target);
    }
    
    //use method of binary search in subarray.
    public int bns(int[] nums, int i, int j, int target){
        while(i < j){
            int mid = (i + j) / 2;
            if(nums[mid] == target) return mid;
            else if(target > nums[mid]) i = mid + 1;
            else j = mid;
        }
        if(nums[j] == target)return i;
        return -1;
    }
}