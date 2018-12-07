class Solution {
    // We start search the matrix from top right corner, initialize the current position to top right corner, 
    // if the target is greater than the value in current position, 
    // then the target can not be in entire row of current position because the row is sorted, 
    // if the target is less than the value in current position, 
    // then the target can not in the entire column because the column is sorted too. 
    // We can rule out one row or one column each time, so the time complexity is O(m+n).
    public boolean searchMatrix(int[][] matrix, int target) {        
        if(matrix.length == 0) return false;
        if(matrix[0].length == 0) return false;
        int row = 0;
        int col = matrix[0].length - 1;
        while(row < matrix.length && col >= 0){
            if(target > matrix[row][col]){
                row++;
            }else if(target < matrix[row][col]){
                col--;
            }else return true;
        }
        return false;
    }
}