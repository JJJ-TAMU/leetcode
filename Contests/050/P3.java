class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int n = nums.length;
        int[] ans = new int[n];
        int value = 0;
        int max = 1 << maximumBit - 1;
        for (int i = 0; i < n; i++) {
            value ^= nums[i];
            ans[n - i - 1] = max ^ value;
        }        
        return ans;
    }
}