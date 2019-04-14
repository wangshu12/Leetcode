class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return null;
        }

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    dfs(matrix, i, j);
                }
            }
        }
        
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                matrix[i][j] = -matrix[i][j];
            }
        }
        
        return matrix;
    }
    
    private void dfs(int[][]matrix, int i, int j){
        
        
        if(j > 0 && (matrix[i][j - 1] == 1 || matrix[i][j] - 1 > matrix[i][j - 1])){
            matrix[i][j - 1] = matrix[i][j] - 1;
            dfs(matrix, i, j - 1);
        }
        
        if(j < matrix[0].length - 1 && (matrix[i][j+1] == 1 || matrix[i][j] - 1 > matrix[i][j+1])){
            matrix[i][j+1] = matrix[i][j] - 1;
            dfs(matrix, i, j+1);
        }
        
        if(i > 0 && (matrix[i-1][j] == 1 || matrix[i][j] - 1 > matrix[i-1][j])){
            matrix[i-1][j] = matrix[i][j] - 1;
            dfs(matrix, i - 1, j);
        }
        
        if(i < matrix.length - 1 && (matrix[i+1][j] == 1 || matrix[i][j] - 1 > matrix[i+1][j])){
            matrix[i+1][j] = matrix[i][j] - 1;
            dfs(matrix, i+1, j);
        }
        
    }
}