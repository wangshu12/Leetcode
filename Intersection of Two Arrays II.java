//External sorting typically uses a hybrid sort-merge strategy. In the sorting phase, chunks of data small enough to fit in main memory are read, sorted, and written out to a temporary file. In the merge phase, the sorted sub-files are combined into a single larger file.
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int i = 0;
        int j = 0;
        int k = 0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> ret = new ArrayList<>();
        
        while(i < nums1.length && j < nums2.length){
            if(nums1[i] == nums2[j]){
                ret.add(nums1[i]);
                i++;
                j++;
            }else if(nums1[i] < nums2[j]){
                i++;
            }else{
                j++;
            }
        }
        int[] r = new int[ret.size()];
        for(int n: ret) r[k++] = n;
        return r;
    }
}