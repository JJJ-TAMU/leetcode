class Solution {
    public int uniquePaths(int m, int n) {
        if (m > n) {    return uniquePaths(n, m);   }
        return nChooseK(m - 1, m + n - 2);
    }

    private static int nChooseK(int k, int n) {
        long ans = 1;
        for (int i = 1, j = n; i <= k; i++, j--) {
            ans = ans * j / i;
        }
        return (int)ans;
    }
}