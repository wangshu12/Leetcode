class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;
        int i = 0; int j = nums.length - 1;
        while(i < j){
            int mid = i + (j - i) / 2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] > nums[j]) i = mid + 1;
            else j = mid;
        }
        System.out.println(i);
        if(nums[i] <= target && target <= nums[nums.length - 1]) return binarySearch(nums, i, nums.length - 1, target);
        else if(i > 0 && nums[0] <= target && target <= nums[i-1]) return binarySearch(nums, 0, i-1, target);
        return -1;
    }
    
    private int binarySearch(int[] nums, int i, int j, int target){
        System.out.println(i + " " + j);
        while(i <= j){
            int mid = i + (j - i) / 2;
            if(nums[mid] == target) return mid;
            else if(target < nums[mid]) j = mid - 1;
            else i = mid + 1;
        }
        return -1;
    }
}