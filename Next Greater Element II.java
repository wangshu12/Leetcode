class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if(nums == null || nums.length == 0) return new int[0];
        Stack<Integer> stack = new Stack<>();
        int[] ret = new int[nums.length];
        for(int i = 0; i < nums.length; i++) ret[i] = -1;
        for(int i = 0; i < nums.length * 2; i++){
            int index = i % nums.length;
            while(!stack.isEmpty() && nums[index] > nums[stack.peek()]){
                int idx = stack.pop();
                ret[idx] = nums[index];
            }
            if(i < nums.length) stack.push(i);
        }
        return ret;
    }
}