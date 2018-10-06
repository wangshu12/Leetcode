class Solution {
    public int islandPerimeter(int[][] grid) {
        if(grid  == null || grid.length == 0 || grid[0].length == 0) return 0;
        int countIsland = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    if((i == 0) || (i > 0 && grid[i - 1][j] == 0)) countIsland ++;
                    if((j == 0) || (j > 0 && grid[i][j - 1] == 0)) countIsland ++;
                    if((i == grid.length - 1) || (i < grid.length - 1 && grid[i + 1][j] == 0)) countIsland ++;
                    if((j == grid[0].length - 1) || (j < grid[0].length - 1 && grid[i][j + 1] == 0)) countIsland++;
                }
            }
        }
        return countIsland;
    }
}