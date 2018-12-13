class Solution {
    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int[] dp = new int[grid[0].length];
        dp[0] = grid[0][0];
        for(int i = 1; i < grid[0].length; i++){
            dp[i] = grid[0][i] + dp[i - 1];
        }
        for(int i = 1; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(j == 0){
                    dp[j] = dp[j] + grid[i][j];
                }else{
                    dp[j] = grid[i][j] + Math.min(dp[j], dp[j - 1]);
                }
            }
        }
        return dp[grid[0].length - 1];
    }
}



class Solution {
    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int rows = grid.length;
        int cols = grid[0].length;
        for(int i = 1; i < rows; i++){
            grid[i][0] = grid[i - 1][0] + grid[i][0];
        }
        for(int i = 1; i < cols; i++){
            grid[0][i] = grid[0][i - 1] + grid[0][i];
        }
        
        for(int i = 1; i < rows; i++){
            for(int j = 1; j < cols; j++){
                grid[i][j] += grid[i - 1][j] < grid[i][j - 1]? grid[i - 1][j] : grid[i][j - 1];
            }
        }
        return grid[rows - 1][cols - 1];
    }
}


class Solution {
    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for(int i = 1; i < grid.length; i++){
            dp[i][0] = grid[i][0] + dp[i - 1][0];
        }
        for(int j = 1; j < grid[0].length; j++){
            dp[0][j] = grid[0][j] + dp[0][j - 1];
        }
        for(int i = 1; i < grid.length; i++){
            for(int j = 1; j < grid[0].length; j++){
                if(dp[i - 1][j] < dp[i][j - 1]){
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                }else{
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                }
            }
        }
        return dp[grid.length - 1][grid[0].length - 1];
    }
}