class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
         for(int j = 0; j < coins.length; j++){ //
           for(int i = 1; i <= amount; i++){
                if(i - coins[j] >= 0 && (dp[i - coins[j]] > 0 || i-coins[j] == 0)){
                    dp[i] += dp[i - coins[j]];
                }
            }
        }
        return dp[amount];
    }
}
// Note that the outer loop should be about coins, while the inner loop should be about amount. 
// Or else, there may be duplicates in the result