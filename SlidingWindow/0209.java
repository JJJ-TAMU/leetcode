class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int minLen = nums.length  + 1;

        int lo = 0;
        for (int hi = 0; hi < nums.length; hi++) {
            sum += nums[hi];
            if (sum < target) { continue;   }
            while (sum >= target) {
                sum -= nums[lo++];
            }
            minLen = Math.min(minLen, hi - lo + 2);
        }

        return minLen == nums.length + 1 ? 0 : minLen;                
    }
}