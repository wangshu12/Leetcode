class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null ||matrix.length == 0 || matrix[0].length == 0) return 0;
        int ret = 0;
        int[][] cache = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                ret = Math.max(ret, helper(cache, matrix, i, j, Integer.MAX_VALUE));
            }
        }
        return ret;
    }
    
    private int helper(int[][] cache, int[][] matrix, int i, int j, int prev){
        if(i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length || matrix[i][j] == -1 || matrix[i][j] >= prev) return 0;
        if(cache[i][j] > 0) return cache[i][j];
        int value = matrix[i][j];
        matrix[i][j] = -1;
        int left = helper(cache, matrix, i, j - 1, value);
        int up = helper(cache, matrix, i - 1, j, value);
        int right = helper(cache, matrix, i, j + 1, value);
        int down = helper(cache, matrix, i + 1, j, value);
        matrix[i][j] = value;
        int steps = 1 + Math.max(Math.max(left, right), Math.max(up, down));
        cache[i][j] = steps;
        return steps;
    }
}

// Use dfs + dp
// First, we use a nested loop to traverse the 2-d matrix.
// For each cell, we use dfs to find the longest increasing increasing path;
// at the same time, we use a dp table to remember the length of the path for each cell; 
// so, when the dp table value > 0, we just return it without using dfs again.
