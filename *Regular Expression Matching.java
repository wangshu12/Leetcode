// 1. dp table represent if s.substring(i) matches p.substring(j);
// 2. base case: when s and p are empty string, then dp[0][0] is true;
// 3. general case: 
//              3.1 if s.charAt(i) -- c1 equals p.charAt(j) -- c2, or c2 == '.':
//                  then dp[i][j] = dp[i - 1][j - 1]; because it depends on whether s.substring(i-1) matches p.substring(j-1);
//              3.2 if c2 == '*'
//                  3.2.1 if c1 == p.charAt(j-2) or p.charAt(j-2) == '.'
//                        then dp[i][j] = dp[i-1][j] -- a* represent one or multiple element, because c1 == p.charAt(j-2);
//                          or dp[i][j] = dp[i][j-2] -- a* represent zero element.
//                  3.2.2 else
//                          dp[i][j] = dp[i][j-2] -- a* represent zero element, because c1 != p.charAt(j-2)
class Solution {
    public boolean isMatch(String s, String p) {
        if(s == null || p == null) return false;
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for(int i = 1; i <= p.length(); i++){
            if(p.charAt(i-1) == '*' && i - 2 >= 0){
                dp[0][i] = dp[0][i-2];
            }
        }
        
        for(int i = 1; i <= s.length(); i++){
            char c1 = s.charAt(i - 1);
            for(int j = 1; j <= p.length(); j++){
                char c2 = p.charAt(j - 1);
                if(c1 == c2 || c2 == '.'){
                    dp[i][j] = dp[i - 1][j - 1];
                }else if(c2 == '*'){
                    if(j - 2 >= 0 && (p.charAt(j-2) == c1 || p.charAt(j-2) == '.')){
                        dp[i][j] = dp[i-1][j] || dp[i][j-2];
                    }else{
                        dp[i][j] = dp[i][j-2];
                    }
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}