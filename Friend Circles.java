class Solution {
    public int findCircleNum(int[][] M) {
        if(M == null || M.length == 0 || M[0].length == 0) return 0;
        int count = 0;
        boolean[] visited = new boolean[M.length];
        for(int i = 0; i < M.length; i++){
            if(visited[i] == false){
                dfs(M, i, visited);
                count++;
            }
        }
        return count;
    }
    
    private void dfs(int[][] M, int firstP, boolean[] visited){
        for(int j = 0; j < M.length; j++){
            if(M[firstP][j] == 1 && visited[j] == false){
                visited[j] = true;
                dfs(M, j, visited);
            }
        }
    }
}