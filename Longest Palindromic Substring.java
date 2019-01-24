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