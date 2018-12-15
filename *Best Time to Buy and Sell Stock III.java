//Space: O(1)
//Time: O(n^2)
class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null) return 0;
        if(prices.length == 0) return 0;
        int ret = 0;
        for(int i = 1; i <= prices.length; i++){
            int p1 = helper(prices, 0, i);
            int p2 = helper(prices, i, prices.length);
            ret = Math.max(ret, p1 + p2);
        }
        return ret;
    }
    
    public int helper(int[] prices, int i, int j){
        if(i == j || i== prices.length) return 0;
        int min = prices[i++];
        int ret = 0;
        for(; i < j; i++){
            while(i < j && prices[i] < prices[i - 1]) i++;
            if(prices[i - 1] < min)
                min = prices[i - 1];
            while(i < j && prices[i] > prices[i - 1]) i++;
            ret = Math.max(ret, prices[i - 1] - min);
        }
        return ret;
    }
}