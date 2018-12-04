// import java.util.Arrays;
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0) return new int[0];
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> ret = new HashSet<>();
        
        for(int num: nums1) set1.add(num);
        for(int num: nums2){
            if(set1.contains(num)) ret.add(num);
        }
        int[] r = new int[ret.size()];
        int i = 0;
        for(Integer num: ret) r[i++] = num;
        return r;
    }
}