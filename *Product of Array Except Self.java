class Solution {
    //The two iterations are basically doing the exact same thing, except one starts from 0 and one starts from end. 
    public int[] productExceptSelf(int[] nums) {
        int[] ret = new int[nums.length];
        ret[0] = 1;
        for(int i = 1; i < nums.length; i++){
            ret[i] = ret[i - 1] * nums[i - 1];
        }
        int back = 1;
        for(int i = nums.length - 1; i >=0; i--){
            ret[i] = ret[i] * back;
            back = back * nums[i];
        }
        return ret;
    }
}

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int prod = 1;
        int zeroCounter = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                zeroCounter++;
            }else{
                prod *= nums[i];
            }
        }
        int[] ret = new int[nums.length];
        // if there are 2 or more zero in the nums, then all of them will be zero;
        if(zeroCounter > 1) return ret;
        for(int i = 0; i < nums.length; i++){
            if(zeroCounter == 1){
                if(nums[i] == 0){
                    ret[i] = prod;
                }
            }else{
                ret[i] = prod / nums[i];
            }
        }
        return ret;
    }
}