class Solution {
    public int maxProfit(int[] prices) {
		int cashFirst = 0, holdFirst = Integer.MIN_VALUE, cashSecond = 0, holdSecond = Integer.MIN_VALUE, cashThird = 0;
		for (int price : prices) {
			cashFirst = cashFirst;
			holdFirst = Math.max(cashFirst - price, holdFirst);
			cashSecond = Math.max(cashSecond, holdFirst + price);
			holdSecond = Math.max(cashSecond - price, holdSecond);
			cashThird = Math.max(cashThird, holdSecond + price);
		}
		return Math.max(cashFirst, Math.max(cashSecond, cashThird));
    }
}