class Solution {
    public int maxProfit(int[] prices) {
        int maxDiff = 0;
        int prevMin = Integer.MAX_VALUE;

        for (int price : prices) {
            if (price > prevMin) {
                maxDiff = Math.max(price - prevMin, maxDiff);
            } else {
                prevMin = price;
            }
        }
        return maxDiff;
    }
}