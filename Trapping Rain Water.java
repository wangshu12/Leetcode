//1. we can image that if there is a larger bar at one end (say right), we are assured that the water trapped would be dependant on height of bar on the left side. 
//2. and the water would be maximum left bar - current height of the bar
class Solution {
    public int trap(int[] height) {
        if(height == null || height.length == 0) return 0;
        int left_i = 0;
        int right_i = height.length - 1;
        int left_max = height[0];
        int right_max = height[right_i];
        int ret = 0;
        while(left_i < right_i){
            int left = height[left_i];
            int right = height[right_i];
            if(left < right){
                left_max = Math.max(left, left_max);
                ret += left_max - height[left_i];
                left_i++;
            }else{
                right_max = Math.max(right, right_max);
                ret += right_max - height[right_i];
                right_i--;
            }
        }
        return ret;
    }
}