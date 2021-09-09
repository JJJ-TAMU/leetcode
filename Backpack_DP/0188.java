class Solution {
    public int maxProfit(int k, int[] prices) {
        int cashInit = 0;
        int[] hold = new int[k + 1];
        Arrays.fill(hold, Integer.MIN_VALUE);
        int[] cash = new int[k + 1];
        for (int price : prices) {
        	cashInit = cashInit;
        	for (int i = 1; i <= k; i++) {
        		hold[i] = Math.max(cash[i - 1] - price, hold[i]);
        		cash[i] = Math.max(cash[i], hold[i] + price);
        	}
        }
        int max = 0;
        for (int ca : cash) {
        	max = Math.max(ca, max);
        }
        return max;
    }
}