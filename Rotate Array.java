class Solution {
    public void rotate(int[] nums, int k) {
        if(k == 0 || nums == null || nums.length == 0 || nums.length == 1) return;
        int revIndex = nums.length - k % nums.length;
        reverse(nums, 0, revIndex - 1);
        reverse(nums, revIndex, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
    }
    
    private void reverse(int[] nums, int start, int end){
        while(start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}