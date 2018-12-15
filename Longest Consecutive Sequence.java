class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            if(map.containsKey(num)){
                continue;
            }else{
                int left = 0;
                int right = 0;
                if(map.containsKey(num - 1)){
                    left = map.get(num - 1);
                }
                if(map.containsKey(num + 1)){
                    right = map.get(num + 1);
                }
                int length = left + right + 1;
                map.put(num, length);
                map.put(num + right, length);
                map.put(num - left, length);
                max = Math.max(length, max);
            }
        }
        return max;
    }
}