class Solution {
    public int maxProfit(int[] prices, int fee) {
        int cash = 0, stock = -prices[0];
        for (int i = 1; i < prices.length; i++) {
        	cash = Math.max(cash, stock + prices[i] - fee);
        	stock = Math.max(cash - prices[i], stock);
        }
        return cash;
    }
}