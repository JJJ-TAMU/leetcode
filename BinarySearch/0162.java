class Solution {
    public int findPeakElement(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mi = lo + (hi - lo) / 2;
            if (nums[mi] > nums[mi + 1]) {  hi = mi;    }
            else {  lo = mi + 1;    }
        }
        return lo;
    }
}