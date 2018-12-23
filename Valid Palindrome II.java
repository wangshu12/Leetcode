// A palindrome is a word that is spelled the same forward and backward.
// We use two pointer to point start character and end character.
// If they are same - just check inside and keep going till you reach the center(start==end)(if odd string) or start>end (if even string)
// If they are NOT same : You now have 2 options
// 2.1) Remove Left Element and Check for the Rest of String OR
// 2.2) Remove Right Element and Check for the Rest of the string.
// If either of them dont give palindrome then its not a palindorme.
class Solution {
    public boolean validPalindrome(String s) {
        if(s == null || s.length() == 0) return false;
        if(s.length() == 1) return true;
        for(int start = 0, end = s.length() - 1; start < end; start++, end--){
            if(s.charAt(start) == s.charAt(end)) continue;
            else return isPalindrome(s,start+1,end) || isPalindrome(s,start,end-1);
        }
        return true;
    }
    
    private boolean isPalindrome(String s, int start, int end){
        while(start < end){
            if(s.charAt(start) != s.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}