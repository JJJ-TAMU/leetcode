class Solution {
    public int minSideJumps(int[] obstacles) {
        int n = obstacles.length;
        int[][] dp = new int[3][n];
        // last column are 0's
        for (int i = n - 2; i >= 0; i--) {
            int obIdx = obstacles[i] - 1;
            for (int j = 0; j < 3; j++) {
                if (j == obIdx) {
                    dp[j][i] = Integer.MAX_VALUE;
                    continue;
                }
                int k = (j + 1) % 3, l = (j + 2) % 3;

                int min;
                // Case 1: no side jump, go to the next postion
                min = dp[j][i + 1];
                
                // Case 2: side jump to k, then go the next position
                if (k != obIdx && dp[k][i + 1] != Integer.MAX_VALUE) {
                    min = Math.min(min, 1 + dp[k][i + 1]);
                }

                // Case 3: side jump to l, then go the next position
                if (l != obIdx && dp[l][i + 1] != Integer.MAX_VALUE) {
                    min = Math.min(min, 1 + dp[l][i + 1]);
                }
                
                dp[j][i] = min;
            }
        }
        return dp[1][0];
    }
}