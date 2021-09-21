class Solution {
    private static final int OFFSET = 10000;
    public int minOperations(int[] nums1, int[] nums2) {
        boolean[] dp = new boolean[OFFSET * 2 + 1];
        dp[OFFSET] = true;
        dfs(dp, nums2, OFFSET, 0);    
    }

    private static dfs(boolean[] dp, int[] nums, int index, int sum) {
        if (index == nums.length) { break;  }
        dp[sum] = true;
        dfs(dp, nums, index + 1, sum);

        for (int i = 0; i < 2; i++) {
            sum += nums[index]
            if (sum > OFFSET * 2) {
                break;
            }
            dfs(dp, nums, index + 1, sum);
        }
    }
}