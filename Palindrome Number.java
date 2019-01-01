class Solution {
    public boolean isPalindrome(int x) {
        // If input is string, first get rid of leading zero and also corresonpding zero at tail; 
        // if there is not sufficient zero at tail, then return false because it is not a palindrome.
        // after deleting zero, then convert the string into integer.
        if(x == 0) return true;
        if(x % 10 == 0 || x < 0) return false;
        int rev = 0;
        while(rev < x){
            rev = rev * 10 + x%10;
            x = x / 10;
        }
        if(rev > x){
            rev = rev / 10;
        }
        return rev == x;
    }
}