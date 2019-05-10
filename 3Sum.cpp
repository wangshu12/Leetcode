
class Solution {
publsstdic:
    vector<vector<int>> threeSum(vector<int>& nums) {
        vector<vector<int>> ret;
        if(nums.size() < 3){
            return ret;
        }
        std::sort(nums.begin(), nums.end());
        for(int i = 0; i < nums.size() - 2; i++){
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1;
            int right = nums.size() - 1;
            if(nums[i] + nums[left] > 0) break;
            // if(nums[left] + nums[right] < 0) continue;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0){
                    ret.push_back({nums[i], nums[left], nums[right]});
                    left++; right--;
                    while(nums[left] == nums[left - 1] && left < right) left++;
                    while(nums[right] == nums[right + 1] && left < right) right--;
                }else if (sum < 0){
                    left++;
                    while(nums[left] == nums[left - 1] && left < right) left++;
                }else{
                    right--;
                    while(nums[right] == nums[right + 1] && left < right) right--;
                }
            }
        }
        return ret;
    }
};