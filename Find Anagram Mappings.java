class Solution {
    public int[] anagramMappings(int[] A, int[] B) {
        if(A == null || B == null || A.length != B.length) return null;
        int[] ret = new int[A.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < B.length; i++){
            map.put(B[i], i);
        }
        
        for(int i = 0; i < ret.length; i++){
            ret[i] = map.get(A[i]);
        }
        return ret;
    }
}