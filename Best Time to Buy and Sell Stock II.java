// we can sum up the difference of local max and local min
class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null) return 0;
        if(prices.length == 0) return 0;
        int localMin = prices[0];
        int localMax = prices[0];
        int ret = 0;
        
        for(int i = 1; i < prices.length; i++){
            while(i < prices.length && prices[i] < prices[i - 1]) i++;
            localMin = prices[i - 1];
            while(i < prices.length && prices[i] > prices[i - 1]) i++;
            localMax = prices[i - 1];
            ret += localMax - localMin;
        }
        return ret;
    }
}