class Solution {
    public int[] sortArrayByParity(int[] A) {
        if(A == null) return null;
        int start = 0, end = A.length - 1;
        while(start < end){
            while(start < end && A[start] % 2 == 0){
                start++;
            }
            while(start < end && A[end] % 2 == 1){
                end--;
            }
            int temp = A[start];
            A[start] = A[end];
            A[end] = temp;
        }
        return A;
    }
}