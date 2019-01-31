class Solution {
    public int[] sortedSquares(int[] A) {
        if(A == null) return null;
        for(int i = 0; i < A.length; i++){
            if(A[i] < 0){
                A[i] = -A[i];
            }
        }
        Arrays.sort(A);
        
        for(int i = 0; i < A.length; i++){
            A[i] = A[i] * A[i];
        }
        return A;
    }
}