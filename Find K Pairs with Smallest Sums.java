class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> ret = new ArrayList<>();
        if(nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0 || k == 0) return ret;
        Comparator<int[]> comp = new Comparator<int[]> (){
            public int compare(int[] i1, int[] i2){
                return i1[0]+i1[1]-i2[0]-i2[1];
            }
        };
        PriorityQueue<int[]> set = new PriorityQueue<>(comp);
        for(int i = 0; i < k && i < nums1.length; i++){
            set.add(new int[]{nums1[i], nums2[0], 0});
        }
        
        while(k > 0 && !set.isEmpty()){
            k--;
            int[] pair = set.poll();
            ret.add(new int[]{pair[0], pair[1]});
            if(pair[2] == nums2.length - 1){
                continue;
            }
            set.add(new int[]{pair[0], nums2[pair[2] + 1], pair[2] + 1});
        }
        return ret;
    }
}