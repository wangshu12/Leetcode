class Solution {
    public int peakIndexInMountainArray(int[] A) {
        if(A == null || A.length < 3) return -1;
        int max = A[0];
        int max_index = 0;
        
        for(int i = 1; i < A.length; i++){
            if(A[i] > max){
                max = A[i];
                max_index = i;
            }
        }
        return max_index;
    }
}

class Solution {
    public int peakIndexInMountainArray(int[] A) {
        if(A == null || A.length < 3) return -1;
        int min = 0;
        int max = A.length - 1;
        
        while(min < max){
            int mid = min + (max - min) / 2;
            if(A[mid + 1] > A[mid]){ //Check if it is ascending
                min = mid + 1;
            }else{
                max = mid;
            }
        }
        return min;
    }
}