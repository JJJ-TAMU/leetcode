class Solution {
    public int twoSumLessThanK(int[] nums, int k) {
        Arrays.sort(nums);
        int lo = 0, hi = nums.length - 1;
        int ans = k;
        while (lo < hi) {
            int sum = nums[lo] + nums[hi];
            if (sum < k) {
                if (ans == k || (ans < k && k - ans > k - sum)) {
                    ans = sum;
                }
                lo++;
            } else {
                hi--;
            }
        }
        return ans == k ? -1 : ans;
    }
}