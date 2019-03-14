class Solution {
    public String[] findRelativeRanks(int[] nums) {
        if(nums == null) return null;
        if(nums.length == 0) return new String[0];
        String[] ret = new String[nums.length];
        
        Integer[] index = new Integer[nums.length];
        for(int i = 0; i < index.length; i++){
            index[i] = i;
        }
        Arrays.sort(index, (a, b) -> (nums[b] - nums[a]));
        
        for(int i = 0; i < nums.length; i++){
            if(i == 0){
                ret[index[i]] = "Gold Medal";
            }else if(i == 1){
                ret[index[i]] = "Silver Medal";
            }else if(i == 2){
                ret[index[i]] = "Bronze Medal";
            }else{
                ret[index[i]] = Integer.toString(i+1);
            }
        }
        return ret;
    }
}