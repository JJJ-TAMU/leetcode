class Solution {
    public int countSubstrings(String s) {
        char[] cs = s.toCharArray();
        return even(cs) + odd(cs);
    }

    private static int even(char[] cs) {
        int counter = 0;
        int n = cs.length;
        int[] dp = new int[n];
        for (int i = 0, l = 0, r = -1; i < n; i++) {
            int k = i > r ? 0 : Math.min(r - i + 1, dp[l + r - i + 1]);
            while (i - k - 1 >= 0 && i + k < n && cs[i - k - 1] == cs[i + k]) {
                k++;
            }
            if (i + k - 1 > r) {
                r = i + k - 1;
                l = i - k;
            }
            counter += k;
        }
        return counter;
    }

    private static int odd(char[] cs) {
        int counter = 0;
        int n = cs.length;
        int[] dp = new int[n];
        for (int i = 0, l = 0, r = -1; i < n; i++) {
            int k = i > r ? 1 : Math.min(r - i + 1, dp[l + r - i]);
            while (i - k >= 0 && i + k < n && cs[i - k] == cs[i + k]) {
                k++;
            }
            if (i + k - 1 > r) {
                r = i + k - 1;
                l = i - k + 1;
            }
            counter += k;
        }
        return counter;
    }
}