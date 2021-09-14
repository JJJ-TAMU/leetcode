class Solution {
    public boolean search(int[] nums, int target) {
        if (nums == null) {     return false;       }
        
        // Step 1: push right end backward until elements in two ends are distinct
        int lo = 0, hi = nums.length - 1;
        while (hi > lo && nums[hi] == nums[lo]) {   hi--;   }   

        // Step 2: check whether rotation happend (only if nums[hi] < nums[lo])
        
        // Case 1: no rotation, range [lo, hi] is sorted
        if (nums[hi] >= nums[lo]) {     return binarySearch(nums, lo, hi, target);  }

        // Case 2: rotation happened
        int rotationIdx = findRotationIdx(nums, lo, hi);

        boolean exists = binarySearch(nums, lo, rotationIdx - 1, target);

        return exists ? exists : binarySearch(nums, rotationIdx, hi, target);
    }

    // returns the rotation index of the rotated array
    private static int findRotationIdx(int[] nums, int lo, int hi) {
        // loop invariant: lo > hi and nums[hi] > nums[hi]
        while (lo < hi) {
            if (lo == hi - 1) {     return hi;      }
            int mi = lo + (hi - lo) / 2;
            if (nums[mi] >= nums[lo]) {     lo = mi;    }
            else {      hi = mi;    }
        }
        return -1;
    }

    // returns true if the target exists in range [lo, hi]
    private static boolean binarySearch(int[] nums, int lo, int hi, int target) {
        while (lo <= hi) {
            int mi = lo + (hi - lo) / 2;
            int cmp = Integer.compare(target, nums[mi]);
            if (cmp < 0)      {     hi = mi - 1;    }
            else if (cmp > 0) {     lo = mi + 1;    }
            else              {     return true;    }
        }
        return false;
    }
}