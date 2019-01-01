// If we solve the problem without doing it in place, we can create an 2d array with the same size.
// And copy the input element into the array, then iterate the input; 
// If we find a zero, then we set the corresponding row and colomn in the copyed array into 0;

// We can also solve it in-place, we can just use first row and column as a memory to keep track of all the 0's in the entire matrix.
// So, the 0 in the first row represents that the column where it is need to be replaced by 0s.
// The 0 in the first column represents that the row where it is need to be replaced by 0s.
// But there are edge cases, for example, if the 0 originally is in the first row, then we need to set the first row into 0 too. And same as the first column

// space: O(1) -- constant space

class Solution {
    public void setZeroes(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return;
        
        //first loop to discover 0s in the matrix
        boolean first_row = false;
        boolean first_col = false;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    if(i == 0) first_row = true;
                    if(j == 0) first_col = true;
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }
        
        //second loop to update our input matrix
        for(int i = 1; i < matrix.length; i++){
            for(int j = 1; j < matrix[0].length; j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
        if(first_row){
            for(int i = 0; i < matrix[0].length; i++){
                matrix[0][i] = 0;
            }
        }
        if(first_col){
            for(int i = 0; i < matrix.length; i++){
                matrix[i][0] = 0;
            }
        }
    }
}


// space: O(n)

class Solution {
    public void setZeroes(int[][] matrix) {
        if(matrix == null) return;
        if(matrix.length == 0) return;
        int[][] copy = new int[matrix.length][matrix[0].length];
        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();
        
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        for(int row: rows){
            for(int j = 0; j < matrix[0].length; j++){
                matrix[row][j] = 0;
            }
        }
        for(int col: cols){
            for(int i = 0; i < matrix.length; i++){
                matrix[i][col] = 0;
            }
        }
    }
}



