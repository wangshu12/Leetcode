class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for(int i = 1; i < dp.length; i++){
            dp[i] = -1;
            for(int j = 0; j < coins.length; j++){
                if(i - coins[j] >= 0 && dp[i - coins[j]] != -1){
                    if(dp[i] == -1) dp[i] = dp[i - coins[j]] + 1;
                    else dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount];
    }
}
class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();
    public int coinChange(int[] coins, int amount) {
        if(map.containsKey(amount)) return map.get(amount);
        if(amount == 0) return 0; if(amount < 0) return -1;
        int min = -1;
        for(int i = 0; i < coins.length; i++){
            int numCoins = coinChange(coins, amount - coins[i]);
            if(numCoins >= 0){
                if(min == -1) min = numCoins + 1;
                else min = Math.min(min, numCoins + 1);
            }
        }
        map.put(amount, min);
        return min;
    }
}
//greedy
public int coinChange(int[] coins, int amount){
    Arrays.sort(coins);
    int count = 0;
    int index = coins.length - 1;
    while(amount > 0 && index >= 0){
        if(amount - coins[index] >= 0){
            amount -= coins[index];
            count++;
        }else{
            index--;
        }
    }
    if(amount > 0) return -1;
    else return count;
}