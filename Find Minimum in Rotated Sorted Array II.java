class Solution {
    public int findMin(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        
        while(i < j){
            int mid = (i + j) / 2;
            if(nums[mid] < nums[j]){
                j = mid;
            }else if(nums[mid] > nums[j]){
                i = mid + 1;
            }else{ //the difference is here!!!! When num[mid] == num[hi], we couldn't sure the position of minimum in mid's left or right, so just let upper bound reduce one.
                j--;
            }
        }
        // while(i > 0 && nums[i-1] <= nums[i]){
        //     i--;
        // }
        return nums[j];
    }
}