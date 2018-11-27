class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k > nums.length) return new int[0];
        int[] ret = new int[nums.length - k + 1];
        int left = 0;
        int right = 0;
        PriorityQueue<Integer> window = new PriorityQueue<>(Collections.reverseOrder());
        while(right < nums.length){
            window.add(nums[right]);
            if(right - left + 1< k){
                right++;
            }else{
                ret[left] = window.peek();
                window.remove(nums[left]);
                left++;
                right++;
            }
        }
        return ret;
    }
}