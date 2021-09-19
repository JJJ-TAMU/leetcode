class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;

        int[] ans = new int[n];
        int lo = 0, hi = n - 1;
        for (int i = n - 1; i >= 0; i--) {
            int front = nums[lo] * nums[lo];
            int end = nums[hi] * nums[hi];
            if (front >= end) {
                ans[i] = front;
                lo++;
            } else {
                ans[i] = end;
                hi--;
            }
        }
        return ans;
    }
}