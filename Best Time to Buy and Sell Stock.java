class Solution {
    public int maxProfit(int[] prices) {
        // variable: min
        // solution: iterate the input array, 
        // first we found the local min, if it is < min, then update min
        // then we fidn the local max, and compute the difference between local max and min, then update the maximum profit.
        // space: O(1)
        // time: O(n)
        
        if(prices == null) return 0;
        if(prices.length == 0) return 0;
        int min = prices[0];
        int ret = 0;
        for(int i = 1; i < prices.length; i++){ //must use for loop; or while loop with extra statement of increasing i.
            while(i < prices.length && prices[i - 1] > prices[i]) i++;
            if(prices[i - 1] < min){
                min = prices[i -1];
            }
            while(i < prices.length && prices[i - 1] < prices[i]) i++;
            ret = Math.max(ret, prices[i - 1] - min);
        }
        return ret;
    }
}