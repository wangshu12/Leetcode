class Solution {
    //The idea is to sweep all 0s to the left and all 2s to the right, then all 1s are left in the middle.
    public void sortColors(int[] nums) {
        int zero = 0;
        int two = nums.length - 1;
        for(int i = 0; i <= two; i++){
            while(nums[i] == 2 && i < two){
                helper(nums, i, two);
                two--;
            }
            while(nums[i] == 0 && i > zero){
                helper(nums, i, zero);
                zero++;
            }
            
        }
    }
    public void helper(int[] nums, int i1, int i2){
        int temp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = temp;
    }
    //remember index of first 0, first 1, first 2
    //
    // public void sortColors(int[] nums) {
    //     int[] map = new int[]{-1, -1, -1};//remember index of first 0, first 1, first 2
    //     for(int i = 0; i < nums.length; i++){
    //         if(nums[i] == 0){
    //             if(map[1] != -1){
    //                 nums[map[1]] = 0;
    //                 map[1] ++;
    //                 nums[i] = 1;
    //             }
    //             if(map[2] != -1){
    //                 nums[map[2]] = nums[i];
    //                 map[2]++;
    //                 nums[i] = 2;
    //             }
    //         }else if(nums[i] == 1){
    //             int index = i;
    //             if(map[2] != -1){
    //                 nums[map[2]] = nums[i];
    //                 index = map[2];
    //                 map[2]++;
    //                 nums[i] = 2;
    //             }
    //             if(map[1] == -1){
    //                 map[1] = index;
    //             }
    //         }else if(nums[i] == 2){
    //             if(map[2] == -1){
    //                 map[2] = i;
    //             }
    //         }
    //     }
    // }
}