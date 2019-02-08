class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        HashMap<Integer, Integer> sum_index = new HashMap<>();
        int maxLength = 0;
        int sum = 0;
        sum_index.put(0, -1);
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if(sum_index.containsKey(sum - k)){
                maxLength = Math.max(maxLength, i - sum_index.get(sum - k));
            }
            if(!sum_index.containsKey(sum)){
                sum_index.put(sum, i);
            }
        }
        return maxLength;
    }
}