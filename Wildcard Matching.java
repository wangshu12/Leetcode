//dp[i][j] indicates whether substring s[i : s.length()] and p[j : j.length()] match.
// base case: if s is empty string and p is empty string, then they are matched, so dp[s.length() + 1][p.length() + 1] = true;
//            else if s is empty string "", s and p matches (dp[i][j] is true) only when p is composed with asterisk "*"
//            else if p is empty string "", s and p does not matched, dp[i][j] is false.
// iteration: if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') then dp[i][j] is true if s.substring(i - 1) matches p.substring(j - 1)
//            if(p.charAt(j) == '*') then dp[i][j] is true if dp[i + 1][j] is true (* acts as any sequence of characters) or dp[i][j+1] is true (* acts as empty sequency).

class Solution {
    public boolean isMatch(String s, String p) {
        if(s == null || p == null) return false;
        boolean[][] table = new boolean[s.length() + 1][p.length() + 1];
        table[s.length()][p.length()] = true;
        for(int i = p.length() - 1; i >= 0; i--){
            if(p.charAt(i) != '*') break;
            else table[s.length()][i] = true;
        }
        
        for(int i = s.length() - 1; i >= 0; i--){
            for(int j = p.length() - 1; j>= 0; j--){
                if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?'){
                    table[i][j] = table[i + 1][j + 1];
                }
                else if(p.charAt(j) == '*'){
                    table[i][j] = table[i + 1][j] || table[i][j + 1];
                }else{
                    table[i][j] = false;
                }
            }
        }
        return table[0][0];
    }
}