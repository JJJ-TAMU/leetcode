class Solution {
    public int consecutiveNumbersSum(int n) {
        int ways = 0;
        int upper = (int)(Math.sqrt(2 * n + 0.25) - 0.5);
        for (int k = 1; k <= upper; k++) {
            if ((n - k * (k + 1) / 2) % k == 0) {
                ways++;
            }
        }
        return ways;
    }
}