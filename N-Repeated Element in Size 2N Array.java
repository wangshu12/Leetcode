class Solution {
    public int repeatedNTimes(int[] A) {
        Set<Integer> freq = new HashSet<>();
        for(int i = 0; i < A.length; i++){
            if(freq.contains(A[i])){
                return A[i];
            }
            freq.add(A[i]);
        }
        return -1;
    }
}