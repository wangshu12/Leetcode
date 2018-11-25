class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>(); //map number with its greater number;
        Stack<Integer> stack = new Stack<>();
        
        for(int i = 0; i < nums2.length; i++){
            while(!stack.isEmpty() && nums2[i] > stack.peek()){
                map.put(stack.pop(), nums2[i]);
            }
            stack.push(nums2[i]);
        }
        int[] ret = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++){
            if(map.containsKey(nums1[i])){
                ret[i] = map.get(nums1[i]);
            }else{
                ret[i] = -1;
            }
        }
        return ret;
    }
}