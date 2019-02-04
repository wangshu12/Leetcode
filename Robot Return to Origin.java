class Solution {
    public boolean judgeCircle(String moves) {
        if(moves == null) return true;
        int horizon = 0, vertical = 0;
        for(int i = 0; i < moves.length(); i++){
            char c = moves.charAt(i);
            if(c == 'U'){
                horizon++;
            }else if(c == 'D'){
                horizon--;
            }else if(c == 'L'){
                vertical++;
            }else{
                vertical--;
            }
        }
        return horizon == 0 && vertical == 0;
    }
}