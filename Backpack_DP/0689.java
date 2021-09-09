class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;

        int[] middle = new int[n];
        for (int i = 0; i < k; i++) {
            middle[k - 1] += nums[i];
        }
        for (int i = k; i < n; i++) {
            middle[k] = middle[k - 1] + nums[i] - nums[i - k];
        }
        int[] left = new int[n];
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int max = sum;
        int index = 0;
        left[0] = 0;
        for (int i = k; i < n; i++) {
            sum += nums[i] - nums[i - k];
            if (sum > max) {
                max = sum;
                index = i - k + 1;
            }
            left[i - k + 1] = index;
        }
    }
}