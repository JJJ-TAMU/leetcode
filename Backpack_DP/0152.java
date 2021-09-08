class Solution {
    public int maxProduct(int[] nums) {
        int max = 1, min = 1;
        int ans = Integer.MIN_VALUE;
        for (int num : nums) {
            int currMax = Math.max(Math.max(max * num, min * num), num);
            int currMin = Math.min(Math.min(max * num, min * num), num);
            max = currMax;
            min = currMin;
            ans = Math.max(ans, max);
        }
        return ans;
    }
}