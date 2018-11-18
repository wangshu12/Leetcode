class Solution {
    public int findMin(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        
        while(i < j){
            int mid = (i + j) / 2;
            if(nums[mid] < nums[j]){
                j = mid;
            }else{
                i = mid + 1; // I think that i = mid + 1 because mid = (i + j) / 2, then mid could not be changed,for exampe, i = 0; j = 1;(because mid equals to floor number of the sum)
            }
        }
        // while(i > 0 && nums[i-1] < nums[i]){
        //     i--;
        // }
        return nums[j];
    }
}

class Solution {
    public int findMin(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        while(i < j){
            int mid = i + (j - i) / 2;
            if(nums[mid] <= nums[j]) j = mid;
            else i = mid + 1;
        }
        return nums[i];
    }
}