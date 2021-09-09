class Solution {
    public int maxProfit(int[] prices) {
		int hold = Integer.MIN_VALUE, sold = 0, reset = 0;
		for (int price : prices) {
			int currSold = hold + price; // hold + sell
			hold = Math.max(hold, reset - price); // max of hold or reset + buy
			reset = Math.max(reset, sold);
			sold = currSold;
		}        
		return Math.max(reset, sold);
    }
}