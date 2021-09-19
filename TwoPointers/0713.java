class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int prev = 1;
        int counter = 0;

        int lo = 0;
        for (int hi = 0; hi < nums.length; hi++) {
            prev *= nums[hi];
            while (prev >= k && lo <= hi) {
                prev /= nums[lo++];
            } 
            counter += hi - lo + 1;
        }

        return counter;
    }
}