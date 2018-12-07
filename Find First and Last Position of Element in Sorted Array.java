class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ret = new int[] {-1, -1};
        if(nums == null) return ret;
        if(nums.length == 0) return ret;
        int i = 0;
        int j = nums.length - 1;
        while(i <= j){
            if(nums[i] != target) i++;
            else if(ret[0] == -1) ret[0] = i;
            if(nums[j] != target) j--;
            else if(ret[1] == -1) ret[1] = j;
            if(ret[0] != -1 && ret[1] != -1) break;
        }
        return ret;
    }
}

// binary search
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ret = new int[] {-1, -1};
        if(nums == null) return ret;
        if(nums.length == 0) return ret;
        int i = 0;
        int j = nums.length - 1;
        int index = -1;
        while(i <= j){
            int mid = i + (j - i) / 2;
            if(nums[mid] == target){
                index = mid;
                break;
            }else if(nums[mid] < target){
                i = mid + 1;
            }else{
                j = mid - 1;
            }
        }
        if(index == -1){
            return ret;
        }
        i = j = index;
        while(j < nums.length-1 && nums[j] == nums[j + 1]){
            j++;
        }
        while(i > 0 && nums[i] == nums[i - 1]){
            i--;
        }
        ret = new int[] {i, j};
        return ret;
    }
}