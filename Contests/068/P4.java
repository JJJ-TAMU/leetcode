class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        // dp[i] is the smallest elements index in range [i, n - 1]
        int[] dp = getSmallestIdx(arr);

        int nChunks = 0;
        int lo = 0;
        // System.out.println(Arrays.toString(dp));
        while (lo < n) {
            lo = getChunkEnd(arr, dp, lo);
            nChunks++;
        }
        return nChunks;
    }

    private static int[] getSmallestIdx(int[] arr) {
        int[] dp = new int[arr.length];
        int n = dp.length;
        int sVal = Integer.MAX_VALUE;
        for (int i = arr.length - 1; i >= 0; i--) {
            dp[i] = sVal;
            if (arr[i] < sVal) {
                sVal = arr[i];
            }
        }
        return dp;
    }

    private static int getChunkEnd(int[] arr, int[] dp, int lo) {
        int max = arr[lo];
        while (lo < arr.length) {
            max = Math.max(arr[lo], max);
            if (max <= dp[lo++]) {
                break;
            }
        }
        return lo;
    }
}