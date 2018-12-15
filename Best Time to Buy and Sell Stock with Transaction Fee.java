class Solution {
    public int maxProfit(int[] prices, int fee) {
        if(prices == null || prices.length <= 1) return 0;
        int ret = 0;
        int buy[] = new int[prices.length];
        int sell[] = new int[prices.length];
        buy[0] = - prices[0] - fee;
        for(int i = 1; i < prices.length; i++){
            buy[i] = Math.max(buy[i - 1], sell[i - 1] - prices[i] - fee); //same as yestoday, or sell on yestoday and buy on today
            sell[i] = Math.max(sell[i - 1],  prices[i] + buy[i - 1]); //same as yestody, or buy min before today, and sell on today.
        }
        return sell[prices.length - 1];
    }
}