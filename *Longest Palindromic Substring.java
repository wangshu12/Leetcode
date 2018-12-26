class Solution {
    public String longestPalindrome(String s) {
        if(s == null) return null;
        if(s.length() == 0) return "";
        String ret = "";
        boolean[][] dp = new boolean[s.length()][s.length()];
        
        for(int i = s.length() - 1; i >= 0; i--){
            for(int j = i; j < s.length(); j++){
                if(s.charAt(i) == s.charAt(j)){
                    if(j - i > 2)
                        dp[i][j] = dp[i+1][j-1];
                    else
                        dp[i][j] = true;
                }
                if(dp[i][j] && j - i + 1 > ret.length()){
                    ret = s.substring(i, j+1);
                }
            }
        }
        return ret;
    }
}

// Choose each elementer as center and expand string from the center if the string is panlindrom
class Solution {
    public String longestPalindrome(String s) {
        if(s == null) return null;
        if(s.length() == 0) return "";
        String ret = "";
        
        for(int i = 0; i < s.length(); i++){
            int len1 = expandAroundCenter(i, i, s);
            int len2 = expandAroundCenter(i, i+1, s);
            int len = Math.max(len1, len2);
            if(len > ret.length()){
                ret = s.substring(i - (len - 1)/2, i + 1 + len/2);
            }
        }
        return ret;
    }
    
    private int expandAroundCenter(int left, int right, String s){
        while(left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return right - left - 1;
    }
}