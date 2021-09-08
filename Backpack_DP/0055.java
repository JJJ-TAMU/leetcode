class Solution {
    public boolean canJump(int[] nums) {
        int min = 0, max = 0;
        int target = nums.length - 1;
        while (max < target) {
            int currMin = max + 1, currMax = max;
            for (int i = min; i <= max; i++) {
                currMax = Math.max(currMax, nums[i] + i);
            }
            if (currMax == max) {
                break;
            }
            max = currMax;
        }     
        return max >= target;
    }
}