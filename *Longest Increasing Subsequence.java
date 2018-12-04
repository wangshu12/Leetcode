// !!!!:
// This questions cannot use deque to solve.
// Because this question wants to find the longest increasing subsequence. The longest increasing subsequencey does not have to be
// the smallest elements.
// Ex:[1,3,6,7,9,4,10,5,6]
// Wrong answer:
class Solution {
    public int lengthOfLIS(int[] nums) {
        int max = 0;
        Deque<Integer> queue = new ArrayDeque<>();
        for(int i = 0; i < nums.length; i++){
            while(queue.size() > 0 && nums[i] <= queue.peekLast()){
                queue.pollLast();
            }
            queue.add(nums[i]);
            max = Math.max(max, queue.size());
        }
        return max;
    }
}

// Whether current number is within lis or not depends on previous numbers in nums array, so it is easy to know that
// it can be solved by dynamic programming.
// Correct answer:
class Solution {
    // use an array to store the inscrease subsequence
    // traverse the input array from 0 to len-1; and use binary search to determine 
    // if the val is bigger than largest in the dp array, add it to the end;
    // if it is among the sequence, return the position that bigger than the value, update the array with this position
    // because we want to keep the sequence element with the smallest number;
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        
        int[] table = new int[nums.length];
        table[0] = nums[0];
        int length = 0;
        for(int i = 1; i < nums.length; i++){
            int pos = bs(length, table, nums[i]);
            if(pos > length){
                length ++;
                table[length] = nums[i];
            }else if(nums[i] < table[pos]){
                table[pos] = nums[i];
            }
        }
        return length +1;
    }
    
    private int bs(int length, int[] table, int number){
        int start = 0;
        int end = length;
        while(start < end){
            int mid = start + (end - start)/2;
            if(table[mid] == number) return mid;
            else if(table[mid] < number) start = mid + 1;
            else end = mid;
        }
        if(table[start]< number && number <= table[end]) return end;
        else if(number > table[end]) return length + 1;
        else return start;
    }
}


//easier solution:
class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int[] table = new int[nums.length];
        table[0] = nums[0];
        int ret = 1;
        
        for(int i = 1; i < nums.length; i++){
            int start = 0;
            int end = ret;
            while(start < end){
                int mid = start + (end - start) / 2;
                if(table[mid] == nums[i]){
                    start = mid;
                    break;
                }
                else if(table[mid] < nums[i]){
                    start = mid + 1;
                }else{
                    end = mid;
                }
            }
            if(start < ret){
                table[start] = nums[i];
            }else{
                table[ret] = nums[i];
                ret++;
            }
        }
        return ret;
    }
}
