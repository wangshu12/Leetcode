public class Solution {
    public boolean search(int[] nums, int target) {
        // note here end is initialized to len instead of (len-1)
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if(nums[mid] == target) return true;
            
            if(nums[mid] > nums[start] || nums[mid] > nums[end]){ //if left side is sorted or right side is unsorted, ex: [3,3,1]
                if(nums[start] <= target && target < nums[mid]){
                    end = mid - 1;
                }else{
                    start = mid + 1;
                }
            }else if(nums[mid] < nums[end] || nums[mid] < nums[start]){ //if right side is sorted or left side is unsorted[3,1,1]
                if(nums[mid] < target && target <= nums[end]){
                    start = mid + 1;
                }else{
                    end = mid - 1;
                }
            ////If we get here, that means nums[start] == nums[mid] == nums[end], [1,3,1,1,1] or [1,1,1,3,1]    
            }else{
                end--;
            }
        }
        return false;
    }
}