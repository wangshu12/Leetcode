class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        if(A == null) return null;
        if(A.length == 0 || A[0].length == 0) return A;
        
        //flip
        for(int i = 0; i < A.length; i++){
            int start = 0, end = A[0].length - 1;
            while(start < end){
                int temp = A[i][start];
                A[i][start] = A[i][end];
                A[i][end] = temp;
                start++;
                end--;
            }
        }
        
        //revert
        for(int i = 0; i < A.length; i++){
            for(int j = 0; j < A[0].length; j++){
                if(A[i][j] == 1){
                    A[i][j] = 0;
                }else{
                    A[i][j] = 1;
                }
            }
        }
        return A;
    }
}