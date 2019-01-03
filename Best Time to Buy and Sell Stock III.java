class Solution {
    public int maxProfit(int[] prices) {
        //Assume that we have no money.
        int buy1 = Integer.MIN_VALUE; // how much money we need to borrow to buy the first stock. We want to borrow less so we want to make buy1 as large as possible, because it is negative.
        int sell1 = 0; // how much profit after selling stock1.
        int buy2 = Integer.MIN_VALUE; // use the money after selling stock1 and may be borrow some money to buy the second stock, buy2 represent how much money we left if buy stock2
        int sell2 = 0; //how much profit after selling the second stock.
        
        for(int i = 0; i < prices.length; i++){
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(sell1, prices[i] + buy1); // becuase buy1 is negative, it is addition.
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, prices[i] + buy2);
        }
        return sell2;
    }
}