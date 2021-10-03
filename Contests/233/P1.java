class Solution {
    public int maxAscendingSum(int[] nums) {
        int maxSum = 0;
        int lo = 0;
        int[] sum = new int[1];
        while (lo < nums.length) {
            lo = getChunSum(nums, lo, sum);
            maxSum = Math.max(maxSum, sum[0]);
        }
        return maxSum;
    }

    private static int getChunSum(int[] nums, int lo, int[] sum) {
        sum[0] = nums[lo++];
        while (lo < nums.length && nums[lo] > nums[lo - 1]) {
            sum[0] += nums[lo++];
        }
        return lo;
    }
}