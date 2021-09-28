class Solution {
    private static final int DIVISOR = 1_000_000_007;
    public int numTilings(int n) {
        long[] ans = new long[Math.max(n, 3) + 1];
        ans[0] = 1;
        ans[1] = 1;
        ans[2] = 2;
        ans[3] = 5;
        for (int i = 4; i <= n; i++) {
            ans[i] = (2 * ans[i - 1] + ans[i - 3]) % DIVISOR;
        }
        return (int)ans[n];
    }
}