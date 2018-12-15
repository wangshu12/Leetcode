// For example: the string is leetcode and wordDicts are leet, code. 
// When we traverse to the letter n, we look backward from n to see if there is an apple: the string is divided into app and lepen (because the length of apple is 5, we expect lepen to be apple, if lepen is indeed apple , and app can also be broken (ie dp[2] = true), then we will set dp[7] = true. but lepenis not apple and dp[2] is false, so we loop to the next wordDict ie pen. The string is divided into apple and the following pen, and the latter substring pen does exist, as well as dp[4] = true, so it can be divided, meaning dp[7]= true.
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s == null || wordDict == null || s.length() == 0 || wordDict.size() == 0) return false;
        Set<Integer> wordIndexSet = new HashSet<>(); //换成Set后 28%
        wordIndexSet.add(-1);
        int n = s.length();
        for(int i = 0; i < n; i++){
            for(Integer prevIndex: wordIndexSet){
                String w = s.substring(prevIndex+1, i+1);
                if(wordDict.contains(w)){
                    wordIndexSet.add(i);
                    break;
                }
            }
        }
        return wordIndexSet.contains(n-1);
        
  
        
    //We also use two index pointers i and j, where i refers to the length of the substring considered currently starting from the beginning, 
    // and j refers to the index of starting of the current substring. 
    //To fill in the dp array, we initialize the element dp[0] as true, since the null string is always present in the dictionary, and the rest of the elements of dp as false.
    // Now, to fill in the entry dp[i], we check if the dp[j] contains true, i.e. if the first substring fulfills the required criteria. If so, we further check if the second substring is present in the dictionary. If both the strings fulfill the criteria, we make dp[i] as true, otherwise as false.
        
        
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for(int i = 1; i <= s.length(); i++){
            for(int j = 0; j < i; j ++){
                if(dp[j] && wordDict.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
        
        
        
      // boolean[] dp = new boolean[s.length()+1];
      // dp[0] = true;
      // for(int i = 1; i <= s.length(); i++) {
      //     for(int j = 0; j < i; j++) {
      //         if(dp[j] && wordDict.contains(s.substring(j,i))){
      //             dp[i] = true;
      //             break;
      //         }
      //     }
      // }
      // return dp[s.length()];

        
        
        // if(s == null || wordDict == null || s.length() == 0 || wordDict.size() == 0) return false;
        // List<Integer> wordIndexSet = new ArrayList<>();
        // wordIndexSet.add(-1);
        // int n = s.length();
        // for(int i = 0; i < n; i++){
        //     for(int j = wordIndexSet.size() - 1; j >=0; j--){ //decreasing j能增加跑速。(87%)
        //         int prevIndex = wordIndexSet.get(j);
        //         String w = s.substring(prevIndex+1, i+1);
        //         if(wordDict.contains(w)){
        //             wordIndexSet.add(i);
        //             break;
        //         }
        //     }
        // }
        // return wordIndexSet.contains(n-1);
    }
}

//Time: O(n^2)
//Space: O(n), n == s.length()