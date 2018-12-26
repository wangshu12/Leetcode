// !!!: We can convert it to an alternative problem "find the longest palindrome substring starts from index 0".
// Then we just insert the reversing substring after the palindrome.
// How to find the the palindrome starting from index 0: use KMP table -- because kmp record the max length of substring that exists in prefix and postfix. Then we can build a temporary string like : string + " " + reverse_string, and run kmp on it to get the kmp table. The reason that we add a empty space in here is to force finding matching starts from the first index in the reverse string.
// Time: O(n)
// Space: O(n)
// What if there is " " in the input string?
class Solution {
    public String shortestPalindrome(String s) {
        if(s == null) return null;
        if(s.length() == 0) return "";
        String temp = s+" "+ new StringBuilder(s).reverse().toString();
        int[] kmpTable = getKMPTable(temp);
        int longestPalinIdx = kmpTable[temp.length() - 1];
        return new StringBuilder(s.substring(longestPalinIdx)).reverse().toString() + s;
    }
    
    private int[] getKMPTable(String s){
        int[] table = new int[s.length()];
        table[0] = 0;
        int prefix_index = 0;
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(prefix_index) == s.charAt(i)){
                table[i] = table[i-1] + 1; //increasing the length of matching substring.
                prefix_index++;
            }else{
                prefix_index = table[i - 1];// we will shorten the match string length, and jump to the prefix part that we used to match postfix ended at i - 1
                while(prefix_index > 0 && s.charAt(prefix_index) != s.charAt(i)){
                    prefix_index = table[prefix_index - 1];
                }
                if(s.charAt(prefix_index) == s.charAt(i)){
                    prefix_index++;
                }
                table[i] = prefix_index;
            }
        }
        return table;
    }
}

// Brute force to find the longest panlindrome substring starting from index 0
//Time: O(n^2) because we interate the input string -- n, and we compare its substring -- n, the result is O(n * n)
class Solution {
    public String shortestPalindrome(String s) {
        if(s == null) return null;
        if(s.length() == 0) return "";
        String revStr = new StringBuilder(s).reverse().toString();
        for(int i = s.length(); i > 0; i--){
            if(s.substring(0, i).equals(revStr.substring(s.length() - i))){
                return revStr.substring(0, s.length() - i) + s;
            }
        }
        return "";
    }
}

// recursive and two pointers
// Time complexity: O(n^2)
// Each iteration of shortestPalindrome is linear in size of substring 
// and the maximum number of recursive calls can be n/2 times as shown in the Intuition section. ("aabababa")
// Let the time complexity of the algorithm be T(n). 
// Since, at the each step for the worst case, the string can be divide into 2 parts 
// and we require only one part for further computation. 
// Hence, the time complexity for the worst case can be represented as : T(n)=T(n-2)+O(n). 
// So, T(n) = O(n) + O(n-2) + O(n-4) + ... + O(1) which is O(n^2)
class Solution {
    public String shortestPalindrome(String s) {
        int palin_index = 0;
        for(int i = s.length() - 1; i >= 0; i--){
            if(s.charAt(palin_index) == s.charAt(i)){
                palin_index++;
            }
        }
        if(palin_index == s.length()){
            return s;
        }
        String rev = new StringBuilder(s.substring(palin_index)).reverse().toString();
        return rev + shortestPalindrome(s.substring(0, palin_index)) + s.substring(palin_index);
    }
}

