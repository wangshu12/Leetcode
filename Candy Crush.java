class Solution {
    public int[][] candyCrush(int[][] board) {
        // First, we traverse the 2d array, and if there are at least 3 cells with the same absolute value rightward or downward, we set them to their negative values.
        
        // After the traversal, we remove these negative values and set them to be zero, and then drop down all nubmers to their correct position. 
        //A easy way is to iterate through each column, for each column, move positive values to the bottom then set the rest to 0.

        // We repeat these steps until there is no crush left.
        boolean hasCrush = true;
        while(hasCrush){
            hasCrush = false;
            for(int i = 0; i < board.length; i++){
                for(int j = 0; j < board[0].length; j++){
                    int value = Math.abs(board[i][j]);
                    if(value == 0) continue; // be careful with edge case;
                    if(j < board[0].length - 2 && Math.abs(board[i][j+1]) == value && Math.abs(board[i][j+2]) == value){
                        hasCrush = true;
                        board[i][j] = -value;
                        board[i][j + 1] = -value;
                        board[i][j + 2] = -value;
                    }
                    
                    if(i < board.length - 2 && Math.abs(board[i + 1][j]) == value && Math.abs(board[i + 2][j]) == value){
                        hasCrush = true;
                        board[i][j] = -value;
                        board[i + 1][j] = -value;
                        board[i + 2][j] = -value;
                    }
                    
                }
            }
            if(hasCrush){
                for(int j = 0; j < board[0].length; j++){
                    int emptyIndex =board.length - 1;
                    for(int i = board.length - 1; i >= 0; i--){
                        if(board[i][j] > 0){
                            board[emptyIndex][j] = board[i][j];
                            emptyIndex--;
                        }
                    }
                    while(emptyIndex >= 0){
                        board[emptyIndex][j] = 0;
                        emptyIndex --;
                    }
                }
            }
        }
        return board;
    }
}