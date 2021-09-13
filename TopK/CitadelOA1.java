public class CitadelOA1 {
	public static void solve(int n, int k) {
		int[] dp = new int[n + 1];
		dp[0] = 1;
		for (int i = 1; i <= k; i++) {
			for (int j = i; j <= n; j++) {
				dp[j] += dp[j - i];
			}
		}
		System.out.println(dp[n]);
	}

	public static void main(String[] args) {
		int n = 8, k = 2;
		solve(n, k);
	}
}