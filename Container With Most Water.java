class Solution {
    public int maxArea(int[] height) {
        int ret = 0;
        if(height == null || height.length < 2){
            return ret;
        }
        int left = 0, right = height.length - 1;
        while(left < right){
            int area = (right - left) * Math.min(height[left], height[right]);
            ret = Math.max(ret, area);
            if(height[left] < height[right] ){
                left++;
            }else if(height[left] > height[right]){
                right--;
            }else{
                if(height[left + 1] < height[left] && height[right - 1] > height[right]){
                    left++;
                }else if(height[left + 1] > height[left] && height[right - 1] < height[right]){
                    right--;
                }else{
                    if(Math.abs(height[left] - height[left + 1]) <= Math.abs(height[right] - height[right - 1])){
                        left++;
                    }else{
                        right--;
                    }
                }
            }
        }
        return ret;
    }
}