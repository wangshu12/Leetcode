class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(nums == null || nums.length == 0) return 0;
        int pro = 1;
        int count = 0;
        for(int i = 0, j = 0; i < nums.length; i++){
            pro *= nums[i];
            while(j <= i && pro >= k){
                pro = pro / nums[j];
                j++;
            }
            count = count + i - j + 1;
        }
        return count;
    }
}