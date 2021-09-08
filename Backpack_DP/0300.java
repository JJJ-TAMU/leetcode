class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    max = Math.max(max, dp[j]);
                }
            }
            dp[i] = max + 1;
        }
        return max(dp);
    }

    private static final int max(int[] dp) {
        int max = 0;
        for (int length : dp) {
            max = Math.max(max, length);
        }
        return max;
    }
}

class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] lis = new int[n];
        int hi = -1;
        for (int num : nums) {
            int rank = rank(lis, hi, num);
            hi = Math.max(rank, hi);
            lis[rank] = num;
        }
        return hi + 1;
    }

    // find number of elements in range [0, hi] which are smaller than target
    private static final int rank(int[] nums, int hi, int target) {
        int lo = 0;
        while (lo <= hi) {
            int mi = lo + (hi - lo) / 2;
            if (nums[mi] < target) {    lo = mi + 1;    }
            else                   {    hi = mi - 1;    }
        }
        return lo;
    }
}