class Solution {
    public int countSubstrings(String s) {
        boolean[][] table = new boolean[s.length()][s.length()];
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            for(int j = 0; j <= i; j++){
                if(s.charAt(i) == s.charAt(j) && (i - j < 3 || table[i-1][j+1])){
                    table[i][j] = true;
                    count++;
                }else{
                    table[i][j] = false;
                }
            }
        }
        return count;
        
        // int n = s.length();
        // boolean[][] table = new boolean[n][n];
        // int count = 0;
        // for(int i = n - 1; i >= 0; i--){
        //     for(int j = i; j < n; j++){
        //         if(s.charAt(i) == s.charAt(j) && (j - i < 3 || table[i + 1][j - 1])){ // you have to check whether the inner substring (the string without the head and the tail characters) is a palindromic substrings or not.
        //             table[i][j] = true;
        //             count++;
        //         }else{
        //             table[i][j] = false;
        //         }
        //     }
        // }
        // return count;
    }
    
}
//n^2