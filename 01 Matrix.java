class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        
        //Find location whose value is 0.
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    queue.add(new Node(i, j));
                    visited[i][j] = true;
                }
            }
        }
        
        //Iterate queue
        while(!queue.isEmpty()){
            Node node = queue.poll();
            int i = node.i;
            int j = node.j;
            update(queue, matrix, visited, i, j, i - 1, j);
            update(queue, matrix, visited, i, j, i + 1, j);
            update(queue, matrix, visited, i, j, i, j - 1);
            update(queue, matrix, visited, i, j, i, j + 1);
        }
        return matrix;
    }
    
    private void update(Queue<Node> queue, int[][] matrix, boolean[][] visited, int i, int j, int x, int y){
        if(x < 0 || y < 0 || x >= matrix.length || y >= matrix[0].length){
            return;
        }
        
        if(!visited[x][y] || (matrix[i][j] + 1 < matrix[x][y])){
            matrix[x][y] = matrix[i][j] + 1;
            queue.add(new Node(x, y));
            visited[x][y] = true;
        }
    }
    
    class Node{
        int i;
        int j;
        public Node(int i, int j){
            this.i = i;
            this.j = j;
        }
    }
}