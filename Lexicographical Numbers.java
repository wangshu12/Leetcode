// If understanding that the question is solved by dfs, then it is easy.
class Solution {
    public List<Integer> lexicalOrder(int n) {
        if(n == 0) return new ArrayList<Integer>();
        List<Integer> ret = new ArrayList<>();
        for(int i = 1; i < 10; i++){
            if(i <= n){
                ret.add(i);
                dfs(i, n, ret);
            }else{
                break;   
            }
        }
        return ret;
    }
    
    public void dfs(int value, int n, List<Integer> ret){
        for(int i = 0; i < 10; i++){
            int newValue = value * 10 + i;
            if(newValue <= n){
                ret.add(newValue);
                dfs(newValue, n, ret);
            }else{
                return;
            }
        }
    }
}

// this is slow but elegant.
class Solution {
    public List<Integer> lexicalOrder(int n) {
        if(n == 0) return new ArrayList<Integer>();
        List<Integer> ret = new ArrayList<>();
        for(int i = 1; i < 10; i++){
            dfs(i, n, ret);
        }
        return ret;
    }
    
    public void dfs(int value, int n, List<Integer> ret){
        if(value <= n){
            ret.add(value);
            for(int i = 0; i < 10; i++){
                dfs(value * 10 + i, n, ret);
            }
        }
    }
}