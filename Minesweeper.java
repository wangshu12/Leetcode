//DFS
class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        if(board == null || click == null || click.length < 2 || 
           click[0] < 0 || click[0] >= board.length || click[1] < 0 || click[1] >= board[0].length){
            return board;
        }
        int row = click[0], col = click[1];
        if(board[row][col] == 'M'){
            board[row][col] = 'X';
        }else{
            dfs(board, row, col);
        }
        
        return board;
    }
    private void dfs(char[][] board, int row, int col){
        if(row < 0 || row >= board.length || 
           col < 0 || col >= board[0].length || 
           board[row][col] != 'E') return;
        int countMine = 0;
        for(int i = -1; i <= 1; i++){
            for(int j = -1; j <= 1; j++){
                if(i == 0 && j == 0) continue;
                if(row+i >= 0 && row+i < board.length &&
                   col+j >= 0 && col+j < board[0].length &&
                   board[row+i][col+j] == 'M') countMine++;
            }
        }
        if(countMine > 0){
            board[row][col] = (char)(countMine + '0');
        }else{
            board[row][col] = 'B';
            for(int i = -1; i <= 1; i++){
                for(int j = -1; j <= 1; j++){
                    dfs(board, row+i, col+j);
                }
            }
        }
    }
}

//BFS
class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        if(board == null || click == null || click.length < 2 || 
           click[0] < 0 || click[0] >= board.length || click[1] < 0 || click[1] >= board[0].length){
            return board;
        }
        int row = click[0], col = click[1];
        if(board[row][col] == 'M'){
            board[row][col] = 'X';
        }else{
            Queue<int[]> queue = new LinkedList<>();
            queue.add(click);
            while(!queue.isEmpty()){
                int[] loc = queue.poll();
                int countMine = 0;
                for(int i = -1; i <= 1; i++){
                    for(int j = -1; j <= 1; j++){
                        if(loc[0]+i >= 0 && loc[0]+i < board.length && 
                           loc[1]+j >= 0 && loc[1]+j < board[0].length &&
                           board[loc[0]+i][loc[1]+j] == 'M'){
                            countMine++;
                        }
                    }
                }
                if(countMine > 0){
                    board[loc[0]][loc[1]] = (char)(countMine + '0');
                }else{
                    board[loc[0]][loc[1]] = 'B';
                    for(int i = -1; i <=1; i++){
                        for(int j = -1; j <= 1; j++){
                            if(loc[0]+i >= 0 && loc[0]+i < board.length && 
                                loc[1]+j >= 0 && loc[1]+j < board[0].length &&
                                board[loc[0]+i][loc[1]+j] == 'E'){
                                    queue.add(new int[]{loc[0]+i, loc[1]+j});
                                    board[loc[0]+i][loc[1]+j] = 'B'; // MARKED TO AVOID TO ADD AGAIN.
                            }
                        }
                    }
                }
            }
        }
        
        return board;
    }
}