class Solution {
    //Start from gates 0, use dfs to fill nearby rooms with distances, and return if (i, j) is out of boundary or has smaller distance filled.
    public void wallsAndGates(int[][] rooms) {
        if(rooms == null || rooms.length == 0 || rooms[0].length == 0) return;
        for(int i = 0; i < rooms.length; i++){
            for(int j = 0; j < rooms[0].length; j++){
                if(rooms[i][j] == 0){
                    dfs(rooms, i, j, 0);
                }
            }
        }
    }
    
    public void dfs(int[][] rooms, int i, int j, int value){
        if(i < 0 || j < 0 || i >= rooms.length || j >= rooms[0].length || rooms[i][j] == -1 || value > rooms[i][j]) return;
        rooms[i][j] = value;
        dfs(rooms, i + 1, j, value + 1);
        dfs(rooms, i, j + 1, value + 1);
        dfs(rooms, i - 1, j, value + 1);
        dfs(rooms, i, j - 1, value + 1);
    }
}