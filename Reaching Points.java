//if (tx > ty), it can be reached only from (tx - ty, ty) so traverse all straight line section(till tx > ty holds) in one shot. The max is taken to ensure that we don't cross beyond sx.
class Solution {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        if(tx < 1 || ty < 1 || sx < 1 || sy < 1 || sx > tx || sy > ty) return false;
        if(sx == tx && sy == ty) return true;
        if(tx > ty){
            int i = Math.max(1, (tx - sx) / ty);
            return reachingPoints(sx, sy, tx - i * ty, ty);
        }else{
            int i = Math.max(1, (ty - sy) / tx);
            return reachingPoints(sx, sy, tx, ty - i * tx);
        }
    }
}