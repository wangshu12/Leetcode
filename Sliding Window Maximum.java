class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k == 0) return new int[0];
        int[] ret = new int[nums.length - k + 1];
        Deque<Integer> indexes = new LinkedList<>();
        int ret_i = 0;
        for(int i = 0; i < nums.length; i++){
            while(indexes.size() > 0 && indexes.peekFirst() < i - k + 1){
                indexes.pollFirst();
            }
            while(indexes.size() > 0 && nums[indexes.peekLast()] < nums[i]){
                indexes.pollLast();
            }
            indexes.addLast(i);
            if(ret_i == i - k + 1){
                ret[ret_i++] = nums[indexes.peekFirst()];
            }
        }
        return ret;
    }
}