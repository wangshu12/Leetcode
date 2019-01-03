class Solution {
    // We can use dfs to mark down a island; also, we can remember the path of dfs by converting it to string. For example.
    public int numDistinctIslands(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        Set<String> set = new HashSet<String>();
        int counter = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == 1){
                    StringBuilder sb = new StringBuilder();
                    //dfs(grid, i, j, 0, 0, sb);
                    bfs(grid, i, j, sb);
                    String s = sb.toString();
                    if(!set.contains(s)){
                        set.add(s);
                        counter++;
                    }
                }
            }
        }
        return counter;
    }
    
    private void dfs(int[][] grid, int startI, int startJ, int diffI, int diffJ, StringBuilder sb){
        if(startI < 0 || startJ < 0 || startI >= grid.length || startJ >= grid[startI].length || grid[startI][startJ] == 0)
            return;
        sb.append(diffI + " " + diffJ + " ");
        grid[startI][startJ] = 0;
        dfs(grid, startI+1, startJ, diffI+1, diffJ, sb);
        dfs(grid, startI, startJ+1, diffI, diffJ+1, sb);
        dfs(grid, startI-1, startJ, diffI-1, diffJ, sb);
        dfs(grid, startI, startJ-1, diffI, diffJ-1, sb);
    }
    
    private void bfs(int[][] grid, int row, int col, StringBuilder sb){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, col});
        grid[row][col] = 0;
        while(!queue.isEmpty()){
            int[] loc = queue.poll();
            sb.append((loc[0] - row) + " " + (loc[1] - col) + " ");
            
            if(loc[0] + 1 < grid.length && grid[loc[0] + 1][loc[1]] == 1){
                grid[loc[0]+1][loc[1]] = 0;
                queue.add(new int[]{loc[0]+1, loc[1]});
            }
            if(loc[1] + 1 < grid[loc[0]].length && grid[loc[0]][loc[1]+1] == 1){
                grid[loc[0]][loc[1]+1] = 0;
                queue.add(new int[]{loc[0], loc[1]+1});
            }
            if(loc[0] - 1 >= 0 && grid[loc[0]-1][loc[1]] == 1){
                grid[loc[0]-1][loc[1]] = 0;
                queue.add(new int[]{loc[0]-1, loc[1]});
            }
            if(loc[1] - 1 >= 0 && grid[loc[0]][loc[1]-1] == 1){
                grid[loc[0]][loc[1]-1] = 0;
                queue.add(new int[]{loc[0], loc[1]-1});
            }
        }
    }
}